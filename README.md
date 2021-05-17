# quarkus-issue--17231

How to reproduce, run from root:
```
mvn clean verify -f aggregator
```

It fails because it does not use the compiled source. It fails on service-deployment with error:
Since I'm using the aggregator I should expect it to the compiled source, instead of downloading it from the repository.
```
[INFO] --- maven-surefire-plugin:3.0.0-M5:test (default-test) @ service-extension-deployment ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.service.extension.test.ServiceExtensionDevModeTest
Downloading from nexusRepository: https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/maven-metadata.xml
Downloading from nexusRepository: https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Downloading from nexusRepository: https://<omitted>/nexus/content/groups/public/org/example/model-extension-deployment/1.0.0-SNAPSHOT/maven-metadata.xml
Downloading from nexusRepository: https://<omitted>/nexus/content/groups/public/org/example/model-extension-deployment/1.0.0-SNAPSHOT/model-extension-deployment-1.0.0-SNAPSHOT.pom
Downloading from nexusRepository: https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.jar
Downloading from nexusRepository: https://<omitted>/nexus/content/groups/public/org/example/model-extension-deployment/1.0.0-SNAPSHOT/model-extension-deployment-1.0.0-SNAPSHOT.jar
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.909 s <<< FAILURE! - in org.example.service.extension.test.ServiceExtensionDevModeTest
[ERROR] org.example.service.extension.test.ServiceExtensionDevModeTest.writeYourOwnDevModeTest  Time elapsed: 0.894 s  <<< ERROR!
java.lang.RuntimeException: java.lang.RuntimeException: io.quarkus.bootstrap.BootstrapException: Failed to create the application model for org.example:service-extension-deployment::jar:1.0.0-SNAPSHOT
Caused by: java.lang.RuntimeException: io.quarkus.bootstrap.BootstrapException: Failed to create the application model for org.example:service-extension-deployment::jar:1.0.0-SNAPSHOT
Caused by: io.quarkus.bootstrap.BootstrapException: Failed to create the application model for org.example:service-extension-deployment::jar:1.0.0-SNAPSHOT
Caused by: io.quarkus.bootstrap.resolver.maven.BootstrapMavenException: Failed to resolve dependencies for org.example:service-extension-deployment:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.resolution.DependencyResolutionException: Failed to collect dependencies at org.example:service-extension:jar:1.0.0-SNAPSHOT -> org.example:model-extension:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.collection.DependencyCollectionException: Failed to collect dependencies at org.example:service-extension:jar:1.0.0-SNAPSHOT -> org.example:model-extension:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.resolution.ArtifactDescriptorException: Failed to read artifact descriptor for org.example:model-extension:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.resolution.ArtifactResolutionException: Could not transfer artifact org.example:model-extension:pom:1.0.0-SNAPSHOT from/to nexusRepository (https://<omitted>/nexus/content/groups/public): Transfer failed for https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Caused by: org.eclipse.aether.transfer.ArtifactTransferException: Could not transfer artifact org.example:model-extension:pom:1.0.0-SNAPSHOT from/to nexusRepository (https://<omitted>/nexus/content/groups/public): Transfer failed for https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Caused by: org.apache.maven.wagon.TransferFailedException: Transfer failed for https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Caused by: java.net.UnknownHostException: <omitted>

[INFO] Running org.example.service.extension.test.ServiceExtensionTest
Downloading from nexusRepository: https://nexus.<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/maven-metadata.xml
Downloading from nexusRepository: https://nexus.<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Downloading from nexusRepository: https://nexus.<omitted>/nexus/content/groups/public/org/example/model-extension-deployment/1.0.0-SNAPSHOT/maven-metadata.xml
Downloading from nexusRepository: https://nexus.<omitted>/nexus/content/groups/public/org/example/model-extension-deployment/1.0.0-SNAPSHOT/model-extension-deployment-1.0.0-SNAPSHOT.pom
Downloading from nexusRepository: https://nexus.<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.jar
Downloading from nexusRepository: https://nexus.<omitted>/nexus/content/groups/public/org/example/model-extension-deployment/1.0.0-SNAPSHOT/model-extension-deployment-1.0.0-SNAPSHOT.jar
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.343 s <<< FAILURE! - in org.example.service.extension.test.ServiceExtensionTest
[ERROR] org.example.service.extension.test.ServiceExtensionTest  Time elapsed: 0.343 s  <<< ERROR!
java.lang.RuntimeException: io.quarkus.bootstrap.BootstrapException: Failed to create the application model for org.example:service-extension-deployment::jar:1.0.0-SNAPSHOT
Caused by: io.quarkus.bootstrap.BootstrapException: Failed to create the application model for org.example:service-extension-deployment::jar:1.0.0-SNAPSHOT
Caused by: io.quarkus.bootstrap.resolver.maven.BootstrapMavenException: Failed to resolve dependencies for org.example:service-extension-deployment:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.resolution.DependencyResolutionException: Failed to collect dependencies at org.example:service-extension:jar:1.0.0-SNAPSHOT -> org.example:model-extension:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.collection.DependencyCollectionException: Failed to collect dependencies at org.example:service-extension:jar:1.0.0-SNAPSHOT -> org.example:model-extension:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.resolution.ArtifactDescriptorException: Failed to read artifact descriptor for org.example:model-extension:jar:1.0.0-SNAPSHOT
Caused by: org.eclipse.aether.resolution.ArtifactResolutionException: Could not transfer artifact org.example:model-extension:pom:1.0.0-SNAPSHOT from/to nexusRepository (https://<omitted>/nexus/content/groups/public): Transfer failed for https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Caused by: org.eclipse.aether.transfer.ArtifactTransferException: Could not transfer artifact org.example:model-extension:pom:1.0.0-SNAPSHOT from/to nexusRepository (https://<omitted>/nexus/content/groups/public): Transfer failed for https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Caused by: org.apache.maven.wagon.TransferFailedException: Transfer failed for https://<omitted>/nexus/content/groups/public/org/example/model-extension/1.0.0-SNAPSHOT/model-extension-1.0.0-SNAPSHOT.pom
Caused by: java.net.UnknownHostException: <omitted>

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   ServiceExtensionDevModeTest.writeYourOwnDevModeTest » Runtime java.lang.Runtim...
[ERROR]   ServiceExtensionTest » Runtime io.quarkus.bootstrap.BootstrapException: Failed...
[INFO] 
[ERROR] Tests run: 2, Failures: 0, Errors: 2, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] Model Extension - Parent 1.0.0-SNAPSHOT ............ SUCCESS [  0.065 s]
[INFO] Model Extension - Runtime 1.0.0-SNAPSHOT ........... SUCCESS [  1.808 s]
[INFO] Model Extension - Deployment 1.0.0-SNAPSHOT ........ SUCCESS [  3.636 s]
[INFO] Service Extension - Parent 1.0.0-SNAPSHOT .......... SUCCESS [  0.001 s]
[INFO] Service Extension - Runtime 1.0.0-SNAPSHOT ......... SUCCESS [  0.193 s]
[INFO] Service Extension - Deployment 1.0.0-SNAPSHOT ...... FAILURE [  2.193 s]
[INFO] aggregator 0.0.1-SNAPSHOT .......................... SKIPPED

```

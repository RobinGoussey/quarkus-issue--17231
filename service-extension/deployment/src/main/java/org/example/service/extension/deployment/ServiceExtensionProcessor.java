package org.example.service.extension.deployment;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.example.service.MyBeanService;

class ServiceExtensionProcessor {

    private static final String FEATURE = "service-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalBeanBuildItem beanBuildItem(){
        return new AdditionalBeanBuildItem(MyBeanService.class);
    }
}

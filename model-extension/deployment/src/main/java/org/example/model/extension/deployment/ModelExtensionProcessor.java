package org.example.model.extension.deployment;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.example.MyBean;

class ModelExtensionProcessor {

    private static final String FEATURE = "model-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalBeanBuildItem beanBuildItem(){
        return new AdditionalBeanBuildItem(MyBean.class);
    }
}

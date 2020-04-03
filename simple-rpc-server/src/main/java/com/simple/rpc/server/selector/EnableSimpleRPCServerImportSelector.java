package com.simple.rpc.server.selector;

import com.simple.rpc.server.annotation.EnableSimpleRPCServer;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 17:12
 **/
public class EnableSimpleRPCServerImportSelector extends SpringFactoryImportSelector<EnableSimpleRPCServer> {

    /**
     * select imports by configure some attributes in @EnableSimpleRPCServer
     * @param metadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        String[] imports = super.selectImports(metadata);

//        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
//                metadata.getAnnotationAttributes(getAnnotationClass().getName(), true));
//
//        boolean autoRegister = attributes.getBoolean("autoRegister");
//
//        if (autoRegister) {
//            List<String> importsList = new ArrayList<>(Arrays.asList(imports));
//            importsList.add(
//                    "org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationConfiguration");
//            imports = importsList.toArray(new String[0]);
//        }
//        else {
//            Environment env = getEnvironment();
//            if (ConfigurableEnvironment.class.isInstance(env)) {
//                ConfigurableEnvironment configEnv = (ConfigurableEnvironment) env;
//                LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//                map.put("spring.cloud.service-registry.auto-registration.enabled", false);
//                MapPropertySource propertySource = new MapPropertySource(
//                        "springCloudDiscoveryClient", map);
//                configEnv.getPropertySources().addLast(propertySource);
//            }
//
//        }

        return imports;
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return null;
    }

    @Override
    protected boolean isEnabled() {
        return false;
    }
}

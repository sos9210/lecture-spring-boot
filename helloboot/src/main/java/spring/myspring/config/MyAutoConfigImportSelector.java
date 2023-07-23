package spring.myspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[] {
//                "spring.myspring.config.autoconfig.DispatcherServletConfig",
//                "spring.myspring.config.autoconfig.TomcatWebServerConfig"
//        };
        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);

        //forEach
        List<String> autoConfigs = new ArrayList<>();
        for (String candidate:candidates) {
            autoConfigs.add(candidate);
        }
        return autoConfigs.toArray(new String[0]);

        //스트림방식
        //return StreamSupport.stream(candidates.spliterator(),false).toArray(String[]::new);
    }
}

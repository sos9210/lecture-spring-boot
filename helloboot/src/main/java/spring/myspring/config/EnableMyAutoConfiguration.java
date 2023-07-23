package spring.myspring.config;

import org.springframework.context.annotation.Import;
import spring.myspring.config.autoconfig.DispatcherServletConfig;
import spring.myspring.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})
@Import(MyAutoConfigImportSelector.class)
public @interface EnableMyAutoConfiguration {
}

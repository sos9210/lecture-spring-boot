package spring.myspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.myspring.config.EnableMyAutoConfiguration;
import spring.myspring.config.autoconfig.DispatcherServletConfig;
import spring.myspring.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
//@Import(Config.class)
//@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}

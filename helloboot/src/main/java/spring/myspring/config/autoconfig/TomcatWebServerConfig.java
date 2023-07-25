package spring.myspring.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import spring.myspring.config.ConditionalMyOnClass;
import spring.myspring.config.MyAutoConfiguration;

//@Configuration
@MyAutoConfiguration
//@Conditional(TomcatWebServerConfig.TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    //Conditional로 체크하는 시점에는 이미 우리가 작성한 빈은 스프링컨테이너에 등록된상태이다.
    //이미 등록된 빈이 있으면 이 ServletWebServerFactory빈을 등록하지 않는다.
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

//    static class TomcatCondition implements Condition {
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            //인자로 주어진 클래스가 포함되어 존재하는지 여부
//            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",context.getClassLoader());
//        }
//    }
}

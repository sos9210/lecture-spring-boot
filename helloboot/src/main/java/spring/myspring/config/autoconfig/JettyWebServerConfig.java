package spring.myspring.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import spring.myspring.config.ConditionalMyOnClass;
import spring.myspring.config.MyAutoConfiguration;

@MyAutoConfiguration
//자동구성을 사용할지 여부를 정하는 Condition인터페이스를 구현한 클래스를 지정한다.
//@Conditional(JettyWebServerConfig.JettyCondition.class)
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

//    static class JettyCondition implements Condition {
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            //인자로 주어진 클래스가 포함되어 존재하는지 여부
//            return ClassUtils.isPresent("org.eclipse.jetty.server.Server",context.getClassLoader());
//        }
//    }
}

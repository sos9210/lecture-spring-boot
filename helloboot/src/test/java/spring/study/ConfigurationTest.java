package spring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

    @Test
    void configuration() {
        //bean1의 common과 bean2의 common은 다르다
//        MyConfig myConfig = new MyConfig();
//        Bean1 bean1 = myConfig.bean1();
//        Bean2 bean2 = myConfig.bean2();
//        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

    }
    
    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }
    
    //@Configuration의 proxyBeanMethods=true(기본)설정인경우 예시와같이 실행된다
    //기존에 common객체가 생성됐으면 그것을 반환하고 아니면 새로 생성한다.
    static class MyConfigProxy extends MyConfig {
        private Common common;
        @Override
        Common common() {
            if(this.common == null) this.common = super.common();
            return this.common;
        }
    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        public Bean1(Common common) {
            this.common = common;
        }
    }
    static class Bean2 {
        private final Common common;

        public Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }
    // Bean1  <-- Common
    // Bean2  <-- Common


}

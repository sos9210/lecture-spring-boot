package spring.myspring.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import spring.myspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPlaceHolderConfig {
    //@Value("${value}") PropertySourcesPlaceholderConfigurer를 빈으로 등록하면
    // 후처리기가 동작하여 @Value의 속성 값이 치환된다.
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

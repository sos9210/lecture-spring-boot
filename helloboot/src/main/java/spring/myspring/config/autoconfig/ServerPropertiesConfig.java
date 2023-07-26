package spring.myspring.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import spring.myspring.config.MyAutoConfiguration;

//다음파트진행을위한주석
//@MyAutoConfiguration
public class ServerPropertiesConfig {


//    @Bean
//    public ServerProperties serverProperties(Environment env) {
////        ServerProperties serverProperties = new ServerProperties();
////
////        serverProperties.setContextPath(env.getProperty("contextPath"));
////        serverProperties.setPort(Integer.parseInt(env.getProperty("port")));
//
//        //스프링부트에서 property값을 편리하게 가져올수 있는 방법을 제공해준다
//        return Binder.get(env).bind("",ServerProperties.class).get();
//
//    }
}

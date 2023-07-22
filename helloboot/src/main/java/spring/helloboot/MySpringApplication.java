package spring.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

    public static void run(Class<?> applicationClass,String[] args) {
        //스프링컨테이너(애노테이션기반)
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                //특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
                //사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                dispatcherServlet.setApplicationContext(this);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {

                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*");
                });
                webServer.start();    //서블릿 컨테이너 실행
            }
        };
        applicationContext.register(applicationClass);
		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
		applicationContext.refresh();
    }
}

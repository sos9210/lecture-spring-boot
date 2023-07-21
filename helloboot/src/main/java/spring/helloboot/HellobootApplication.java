package spring.helloboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

//	public static void main(String[] args) {
//		//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//		//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//			servletContext.addServlet("hello", new HttpServlet() {
//				@Override
//				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//					String name = req.getParameter("name");
//					//상태코드 ,헤더, 바디
//					//resp.setStatus(200);
//					//resp.setHeader("Content-Type","text/plain");
//					resp.setStatus(HttpStatus.OK.value());
//					resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
//					resp.getWriter().println("Hello Servlet " + name);
//				}
//			}).addMapping("/hello");
//		});
//		webServer.start();	//서블릿 컨테이너 실행
//	}
//	public static void main(String[] args) {
//		//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//		//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//			servletContext.addServlet("frontcontrollr", new HttpServlet() {
//				@Override
//				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//					//인증,보안,다국어, 각종 공통기능 처리
//					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
//
//						String name = req.getParameter("name");
//
//						resp.setStatus(HttpStatus.OK.value());
//						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
//						resp.getWriter().println("Hello Servlet " + name);
//					}else if(req.getRequestURI().equals("/user")) {
//
//					}else {
//						resp.setStatus(HttpStatus.NOT_FOUND.value());
//					}
//				}
//			}).addMapping("/*");
//		});
//		webServer.start();	//서블릿 컨테이너 실행
//	}
	public static void main(String[] args) {
		//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
		//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {

			HelloController helloController = new HelloController();

			servletContext.addServlet("frontcontrollr", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					//인증,보안,다국어, 각종 공통기능 처리
					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
						String name = req.getParameter("name");

						String ret = helloController.hello(name);

						resp.setStatus(HttpStatus.OK.value());
						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
					}else if(req.getRequestURI().equals("/user")) {

					}else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");
		});
		webServer.start();	//서블릿 컨테이너 실행
	}

}

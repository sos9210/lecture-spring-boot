package boot.helloboot;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

//@Configuration
//@ComponentScan
@SpringBootApplication
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
//	public static void main(String[] args) {
//		//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//		//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
//			HelloController helloController = new HelloController();
//
//			servletContext.addServlet("frontcontrollr", new HttpServlet() {
//				@Override
//				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//					//인증,보안,다국어, 각종 공통기능 처리
//					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
//						String name = req.getParameter("name");
//
//						String ret = helloController.hello(name);
//
//						resp.setStatus(HttpStatus.OK.value());
//						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
//						resp.getWriter().println(ret);
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
//	public static void main(String[] args) {
//		//스프링컨테이너
//		GenericApplicationContext applicationContext = new GenericApplicationContext();
//
//		//스프링컨테이너에 컨트롤러 빈을 등록한다
//		applicationContext.registerBean(HelloController.class);
//		applicationContext.registerBean(SimpleHelloService.class);
//		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
//		applicationContext.refresh();
//
//		//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//		//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
////			HelloController helloController = new HelloController();
//
//			servletContext.addServlet("frontcontrollr", new HttpServlet() {
//				@Override
//				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//					//인증,보안,다국어, 각종 공통기능 처리
//					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
//						String name = req.getParameter("name");
//
//						HelloController helloController = applicationContext.getBean(HelloController.class);
//						String ret = helloController.hello(name);
//
//						//resp.setStatus(HttpStatus.OK.value());
//						//resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
//						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
//						resp.getWriter().println(ret);
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
//	public static void main(String[] args) {
//		//스프링컨테이너
//		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
//
//		//스프링컨테이너에 컨트롤러 빈을 등록한다
//		applicationContext.registerBean(HelloController.class);
//		applicationContext.registerBean(SimpleHelloService.class);
//		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
//		applicationContext.refresh();
//
//		//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//		//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
//			servletContext.addServlet("dispatcherServlet",
//						new DispatcherServlet(applicationContext)
//					).addMapping("/*");
//		});
//		webServer.start();	//서블릿 컨테이너 실행
//	}
//	public static void main(String[] args) {
//		//스프링컨테이너
//		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//				//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
//					servletContext.addServlet("dispatcherServlet",
//							new DispatcherServlet(this)
//					).addMapping("/*");
//				});
//				webServer.start();	//서블릿 컨테이너 실행
//			}
//		};
//
//		//스프링컨테이너에 컨트롤러 빈을 등록한다
//		applicationContext.registerBean(HelloController.class);
//		applicationContext.registerBean(SimpleHelloService.class);
//		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
//		applicationContext.refresh();
//
//	}

//	@Bean
//	public HelloController helloController(HelloService helloService) {
//		return new HelloController(helloService);
//	}
//	@Bean
//	public HelloService helloService() {
//		return new SimpleHelloService();
//	}
//
//	public static void main(String[] args) {
//		//스프링컨테이너(애노테이션기반)
//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//				//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
//					servletContext.addServlet("dispatcherServlet",
//							new DispatcherServlet(this)
//					).addMapping("/*");
//				});
//				webServer.start();	//서블릿 컨테이너 실행
//			}
//		};
//
//		//스프링컨테이너에 컨트롤러 빈을 등록한다
////		applicationContext.registerBean(HelloController.class);
////		applicationContext.registerBean(SimpleHelloService.class);
//		applicationContext.register(HellobootApplication.class);
//		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
//		applicationContext.refresh();
//
//	}

//	public static void main(String[] args) {
//		//스프링컨테이너(애노테이션기반)
//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//				//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
//					servletContext.addServlet("dispatcherServlet",
//							new DispatcherServlet(this)
//					).addMapping("/*");
//				});
//				webServer.start();	//서블릿 컨테이너 실행
//			}
//		};
//
//		//스프링컨테이너에 컨트롤러 빈을 등록한다
////		applicationContext.registerBean(HelloController.class);
////		applicationContext.registerBean(SimpleHelloService.class);
//		applicationContext.register(HellobootApplication.class);
//		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
//		applicationContext.refresh();
//
//	}
//	@Bean
//	public ServletWebServerFactory servletWebServerFactory() {
//		return new TomcatServletWebServerFactory();
//	}
//	@Bean
//	public DispatcherServlet dispatcherServlet() {
//		return new DispatcherServlet();
//	}
//	public static void main(String[] args) {
//		run(HellobootApplication.class,args);
//
//	}
//
//	private static void run(Class<?> applicationClass,String[] args) {
//		//스프링컨테이너(애노테이션기반)
//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				//특정 서블릿컨테이너에 종속되지 않은 추상화된 ServletWebServerFactory가 제공됨
//				//사용하는 서블릿컨테이너(jetty,undertow등등...) 마다 구현체를 만들어서 사용할 수 있음
//				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
//				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//				dispatcherServlet.setApplicationContext(this);
//
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//
//					servletContext.addServlet("dispatcherServlet",dispatcherServlet)
//							.addMapping("/*");
//				});
//				webServer.start();	//서블릿 컨테이너 실행
//			}
//		};
//
//		//스프링컨테이너에 컨트롤러 빈을 등록한다
////		applicationContext.registerBean(HelloController.class);
////		applicationContext.registerBean(SimpleHelloService.class);
//		applicationContext.register(applicationClass);
//		//스프링컨테이너의 현재 구성정보를 이용해 초기화작업 진행 (등록한 스프링 빈 객체 생성)
//		applicationContext.refresh();
//	}

	@Bean
	ApplicationRunner applicationRunner (Environment env) {
		return args -> {
			String name = env.getProperty("my.name");
			System.out.println("my.name = " + name);
		};
	}
	private final ListableBeanFactory listableBeanFactory;
	private final JdbcTemplate jdbcTemplate;

	public HellobootApplication(ListableBeanFactory listableBeanFactory, JdbcTemplate jdbcTemplate) {
		this.listableBeanFactory = listableBeanFactory;
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
		Arrays.stream(listableBeanFactory.getBeanDefinitionNames()).toList().forEach(v -> {
			System.out.println("bean = "+v);
		});
	}

	public static void main(String[] args) {
		//MySpringApplication.run(HellobootApplication.class,args);
		SpringApplication.run(HellobootApplication.class,args);

	}
}

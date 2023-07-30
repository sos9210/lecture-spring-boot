package boot.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    public String hello(String name) {
//        return "Hello " + name;
//    }
    private final HelloService helloService;
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    @GetMapping("/hello")
//    public String hello(String name) {
//        SimpleHelloService helloService = new SimpleHelloService();
//        return helloService.sayHello(Objects.requireNonNull(name));
//    }

    @GetMapping("/hello")
    public String hello(String name) {
        if(name == null || name.length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name +" : " + helloService.countOf(name);
    }
}

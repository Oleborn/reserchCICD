package oleborn.testcicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot in Docker!";
    }

    @GetMapping("/testCICD")
    public String testCICD() {
        return "Ебать-колотить, работает! АХуЕТЬ";
    }
}

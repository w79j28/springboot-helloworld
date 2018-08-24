package com.test.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication 
public class Application {
    @RequestMapping("/")
    public String home() {
	System.out.println("测试git回滚");
        return "Hello Spring Boot!";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

package com.example.springbootapplication;

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/foundation")
    public Resource foundation() throws IOException {
        Path path = Paths.get(new ClassPathResource("static/foundationCourses.html").getURI());
        return new ClassPathResource("static/foundationCourses.html");
    }

}

package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TechnicalBlog {
    public static void main(String[] args)
    {
        SpringApplication.run(TechnicalBlog.class,args);
    }
}

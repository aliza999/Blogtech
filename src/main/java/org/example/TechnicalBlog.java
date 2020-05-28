package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration


public class  TechnicalBlog
{
    public static void main(String[] args)
    {
        SpringApplication.run(TechnicalBlog.class,args);
    }
}

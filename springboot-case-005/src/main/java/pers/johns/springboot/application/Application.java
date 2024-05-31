package pers.johns.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * ClassName    : Application
 * Description  : TODO
 * CreateTime   : 2024/5/31 10:19
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootApplication
public class Application {

    @Bean("username")
    public String getUsername() {
        return "John";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

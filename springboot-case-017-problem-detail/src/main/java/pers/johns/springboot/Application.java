package pers.johns.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pers.johns.springboot.config.BookContainer;

/**
 * ClassName    : Application
 * Description  :
 * CreateTime   : 2024/6/8 15:02
 *
 * @author : JohnS
 * @version : 1.0
 */

@EnableConfigurationProperties(BookContainer.class)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

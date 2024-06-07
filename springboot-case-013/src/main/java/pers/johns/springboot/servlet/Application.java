package pers.johns.springboot.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * ClassName    : Application
 * Description  : 核心启动类
 * CreateTime   : 2024/6/7 9:26
 *
 * @author : JohnS
 * @version : 1.0
 */

@ServletComponentScan({
        "pers.johns.springboot.servlet.web.servlet"
})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

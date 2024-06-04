package pers.johns.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan({
        "pers.johns.springboot.mybatis.mapper",
        "pers.johns.springboot.mybatis.dao",
        "pers.johns.springboot.mybatis.repository"
})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

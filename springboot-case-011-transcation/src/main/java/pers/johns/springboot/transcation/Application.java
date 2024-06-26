package pers.johns.springboot.transcation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName    : Application
 * Description  :
 * CreateTime   : 2024/6/5 15:47
 *
 * @author : JohnS
 * @version : 1.0
 */

@EnableTransactionManagement
@MapperScan("pers.johns.springboot.transcation.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

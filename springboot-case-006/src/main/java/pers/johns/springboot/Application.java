package pers.johns.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import pers.johns.springboot.bean.MyCollection;
import pers.johns.springboot.bean.NestAppBean;
import pers.johns.springboot.config.BeanConfig;

/**
 * ClassName    : Application
 * Description  : SpringBoot启动类，核心配置文件
 * CreateTime   : 2024/5/31 18:31
 *
 * @author : JohnS
 * @version : 1.0
 */

/*
@EnableConfigurationProperties({
        NestAppBean.class,
        MyCollection.class
})*/
@ConfigurationPropertiesScan("pers.johns.springboot.bean")
@SpringBootApplication
@Import(BeanConfig.class)
@ImportResource(locations = {"classpath:spring.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

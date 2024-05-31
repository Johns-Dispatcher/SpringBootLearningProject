package pers.johns.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import pers.johns.springboot.service.SomeService;

/**
 * ClassName    : ApplicationTest
 * Description  : 测试配置文件
 * CreateTime   : 2024/5/31 18:42
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private SomeService service;

    @Autowired
    private Environment environment;

    /**
     * 测试默认配置文件中的属性
     */
    @Test
    public void testDefaultConfig() {
        service.printValue();
    }

    /**
     * 测试Environment对象
     */
    @Test
    public void testEnvironment() {
        String appName = environment.getProperty("app.name");

        System.out.println("App Name: " + appName);

        System.out.println("Author: " +
                (environment.containsProperty("app.author") ? environment.getProperty("app.author") : "NONE AUTHOR")
        );

        Integer port = environment.getProperty("app.port", Integer.class, 8080);
        System.out.println("Port: " + port);
    }
}

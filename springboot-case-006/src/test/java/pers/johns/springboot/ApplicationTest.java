package pers.johns.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import pers.johns.springboot.bean.AppBean;
import pers.johns.springboot.bean.NestAppBean;
import pers.johns.springboot.service.SomeService;

/**
 * ClassName    : ApplicationTest
 * Description  : 测试配置文件
 * CreateTime   : 2024/5/31 18:42
 *
 * @author : JohnS
 * @version : 1.0
 */

@EnableConfigurationProperties(NestAppBean.class)
// @ConfigurationPropertiesScan("pers.johns.springboot.bean")
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private SomeService service;

    @Autowired
    private Environment environment;

    @Autowired
    private AppBean appBean;

    @Autowired
    private NestAppBean nestAppBean;

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

    /**
     * 测试多配置文件
     */
    @Test
    public void testExtraConfig() {
        String redisHost = environment.getProperty("spring.redis.host");
        String datasourceUrl = environment.getProperty("spring.datasource.url");

        System.out.println("Redis Host: " + redisHost);
        System.out.println("Datasource Url: " + datasourceUrl);
    }

    /**
     * 测试环境配置文件
     */
    @Test
    public void testExtraProfiles() {
        String memo = environment.getProperty("myapp.memo");
        System.out.println("Memo: " + memo);
    }

    /**
     * 测试配置文件注入到Bean属性
     */
    @Test
    public void testPropertiesBean() {
        System.out.println(appBean);
    }

    /**
     * 测试嵌套配置注入到Bean
     */
    @Test
    public void testNestBean() {
        System.out.println(nestAppBean);
    }
}

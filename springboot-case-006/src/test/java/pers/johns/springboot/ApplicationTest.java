package pers.johns.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import pers.johns.springboot.bean.*;
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

    @Autowired
    private AppBean appBean;

    @Autowired
    private NestAppBean nestAppBean;

    @Autowired
    private Security security;

    @Autowired
    private MyCollection myCollection;

    @Autowired
    private Group group;

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

    /**
     * 测试以方法方式注入构建第三方库对象
     */
    @Test
    public void testThirdBean() {
        System.out.println(security);
    }

    /**
     * 测试集合相关属性注入
     */
    @Test
    public void testCollectionProperties() {
        System.out.println(myCollection);
    }

    /**
     * 测试外部单独文件数据源注入
     */
    @Test
    public void testPropertySource() {
        System.out.println(group);
    }
}

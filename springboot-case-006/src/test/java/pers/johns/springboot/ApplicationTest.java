package pers.johns.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    public void testDefaultConfig() {
        service.printValue();
    }
}

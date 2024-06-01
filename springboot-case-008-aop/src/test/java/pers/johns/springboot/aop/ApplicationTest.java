package pers.johns.springboot.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.johns.springboot.aop.service.inter.SomeService;

/**
 * ClassName    : ApplicationTest
 * Description  : 测试类
 * CreateTime   : 2024/6/1 22:56
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private SomeService someService;

    /**
     * 测试切面方法是否成功切入
     */
    @Test
    public void testAspectLog() {
        someService.query(10);
        someService.save("John", 30);
    }
}

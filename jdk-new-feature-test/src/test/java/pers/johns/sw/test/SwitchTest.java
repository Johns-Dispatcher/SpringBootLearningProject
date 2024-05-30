package pers.johns.sw.test;

import org.junit.Test;

import java.util.Random;

/**
 * ClassName    : SwitchTest
 * Description  : 测试Switch相关的新特性
 * CreateTime   : 2024/5/30 16:28
 *
 * @author : JohnS
 * @version : 1.0
 */
public class SwitchTest {

    private static final Random random = new Random();

    @Test
    public void testArrow() {
        int dow = SwitchTest.random.nextInt()%10;
        switch (dow) {
            case 1, 2, 3, 4, 5 -> System.out.println("工作日");
            case 6, 7 -> System.out.println("休息日");
            default -> System.out.println("日期错误");
        }
    }
}

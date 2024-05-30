package pers.johns.var.test;

import org.junit.Test;

/**
 * ClassName    : VarTest
 * Description  : 测试var声明变量
 * CreateTime   : 2024/5/30 22:09
 *
 * @author : JohnS
 * @version : 1.0
 */
public class VarTest {
    @Test
    public void testVar() {
        var i = 1;
        System.out.println(i);
        System.out.println(((Object) i).getClass().getName());
    }
}

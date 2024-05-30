package pers.johns.textblock.test;

import org.junit.Test;

/**
 * ClassName    : TextBlockTest
 * Description  : 测试文本块的使用
 * CreateTime   : 2024/5/30 18:37
 *
 * @author : JohnS
 * @version : 1.0
 */
public class TextBlockTest {

    /**
     * 测试文本块
     */
    @Test
    public void testTextBlock() {
        String textBlock =
            """
            SELECT
                *
            FROM
                oa
            WHERE
                id = 1
            """;
        System.out.println(textBlock);
        String indented = textBlock.indent(2);
        System.out.println(indented);
    }
}

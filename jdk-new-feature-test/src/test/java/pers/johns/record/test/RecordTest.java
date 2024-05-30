package pers.johns.record.test;

import org.junit.Test;
import pers.johns.record.Student;

/**
 * ClassName    : RecordTest
 * Description  : 测试Record新特性
 * CreateTime   : 2024/5/30 12:43
 *
 * @author : JohnS
 * @version : 1.0
 */
public class RecordTest {

    @Test
    public void testRecord() {
        Student student01 = new Student(1001, "John", "John@1.com", 22);
        System.out.println(student01);

        System.out.println("Student01 Id:" + student01.id());
        System.out.println("Student01 Name" + student01.name());

        Student student02 = new Student(1002, "Jonathan", "Jonathan@1.com", 25);

        System.out.println(student01.equals(student02));

        System.out.println("Student02 Id:" + student02.id());
        System.out.println("Student02 Name" + student02.name());
    }
}

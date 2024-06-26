package pers.johns.record.test;

import org.junit.Test;
import pers.johns.record.Product;
import pers.johns.record.Student;

import java.awt.print.Printable;

/**
 * ClassName    : RecordTest
 * Description  : 测试Record新特性
 * CreateTime   : 2024/5/30 12:43
 *
 * @author : JohnS
 * @version : 1.0
 */
public class RecordTest {

    /**
     * 测试Record类的使用
     */
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

    /**
     * 测试Record的实例方法
     */
    @Test
    public void testRecord02() {
        Student student01 = new Student(1001, "John", "John@1.com", 22);

        System.out.println(student01.concat());
    }

    /**
     * 测试Record的静态方法
     */
    @Test
    public void testRecordStatic() {
        System.out.println(Student.emailToUpCase(null));
        System.out.println(Student.emailToUpCase("john@s1.com"));
    }

    /**
     * 测试Record的构造函数
     */
    @Test
    public void testRecordConstruct() {
        Student student = new Student(11, "Alice");
        System.out.println(student);
    }

    /**
     * 测试Record实现接口
     */
    @Test
    public void testRecordWithInterface() {
        Product product = new Product(1001, "Computer");
        product.print();
    }

    /**
     * 定于局部Record类型，并测试
     */
    @Test
    public void testInnerRecord() {
        record SaleRecord(Integer id, String productName){};

        SaleRecord car = new SaleRecord(1001, "Car");
        System.out.println(car);
    }

    /**
     * 测试嵌套格式的Record
     */
    @Test
    public void testNestedRecord() {
        record Address(String city, String address){};
        record Phone(String phoneNumber){};
        record Person(String name, Address address, Phone phone){}

        System.out.println(new Person(
                "John",
                new Address("Liaoning", "1-1-1"),
                new Phone("114514")
        ));
    }
}

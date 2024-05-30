package pers.johns.record;

import java.util.Optional;

public record Student(Integer id, String name, String email, Integer age) {

    /**
     * 实例方法
     * @return 姓名与年龄的聚合信息
     */
    public String concat() {
        return String.format("姓名是%s，年龄是%s", name, age);
    }

    /**
     * 静态方法 将指定邮箱变为大写
     * @param email 邮箱地址
     * @return 大写邮箱地址
     */
    public static String emailToUpCase(String email) {
        return Optional.ofNullable(email).orElse("no email").toUpperCase();
    }

    /**
     * 紧凑型构造方法
     */
    public Student {
        System.out.println("id is " + id);
        if (id < 1) {
            throw new RuntimeException("id is too Small");
        }
    }

    /**
     * 自定义构造方法
     * @param id 用户id
     * @param name 用户姓名
     */
    public Student(Integer id, String name) {
        this(id, name, null, null);
    }
}

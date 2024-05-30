package pers.johns.record;

import java.util.Optional;

public record Student(Integer id, String name, String email, Integer age) {
    public String concat() {
        return String.format("姓名是%s，年龄是%s", name, age);
    }

    public static String emailToUpCase(String email) {
        return Optional.ofNullable(email).orElse("no email").toUpperCase();
    }
}

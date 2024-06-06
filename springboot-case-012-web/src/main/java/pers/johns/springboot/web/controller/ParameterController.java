package pers.johns.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.johns.springboot.web.model.pojo.User;

/**
 * ClassName    : ParameterController
 * Description  : 测试参数接收
 * CreateTime   : 2024/6/6 15:03
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/param")
public class ParameterController {

    @GetMapping("/normal")
    public String normalParam(
            @RequestParam("name")
            String name,
            @RequestParam("age")
            Integer age,
            @RequestParam("gender")
            String gender
    ) {
        return String.format("Name=%s, Age=%d, Gender=%s", name, age, gender);
    }

    @GetMapping("/bean")
    public String beanParam(User user) {
        return user.toString();
    }
}

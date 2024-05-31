package pers.johns.springboot.application.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName    : HelloController
 * Description  : TODO
 * CreateTime   : 2024/5/31 10:20
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
public class HelloController {

    @Resource(name = "username")
    private String username;

    @RequestMapping("/hello")
    public String hello() {
        return "Spring Boot 3! " + username;
    }
}

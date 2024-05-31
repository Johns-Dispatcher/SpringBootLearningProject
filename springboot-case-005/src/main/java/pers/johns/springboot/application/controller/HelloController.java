package pers.johns.springboot.application.controller;

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

    @RequestMapping("/hello")
    public String hello() {
        return "Spring Boot 3!";
    }
}

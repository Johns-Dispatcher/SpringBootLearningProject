package pers.johns.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName    : ThymeleafController
 * Description  :
 * CreateTime   : 2024/6/9 23:19
 *
 * @author : JohnS
 * @version : 1.0
 */

@Controller
public class ThymeleafController {

    @GetMapping("/exp")
    public String toExp(Model model) {

        model.addAttribute("username", "John");
        model.addAttribute("password", "123456");

        return "exp";
    }
}

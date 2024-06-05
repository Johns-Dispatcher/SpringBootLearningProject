package pers.johns.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * ClassName    : QuickController
 * Description  : 控制器
 * CreateTime   : 2024/6/5 22:30
 *
 * @author : JohnS
 * @version : 1.0
 */

@Controller
public class QuickController {

    @RequestMapping("/quick")
    public String toQuick(Model model) {
        model.addAttribute("serverMessage", "Quick Message");
        return "quick";
    }
}

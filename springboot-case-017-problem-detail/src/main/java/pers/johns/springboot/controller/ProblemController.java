package pers.johns.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName    : ProblemController
 * Description  :
 * CreateTime   : 2024/6/8 17:25
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/problem")
public class ProblemController {

    @GetMapping("/not-found")
    public String doNotFound() {
        return "图书的ISBN可能不存在，请检测输入信息";
    }

}

package pers.johns.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName    : ComputeController
 * Description  :
 * CreateTime   : 2024/6/7 23:05
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/compute")
public class ComputeController {

    @PostMapping("/divide")
    public String doDivide(Integer dividend, Integer divisor) {

        if (dividend == 0) throw new RuntimeException("被除数请不要输入0");

        int result = dividend / divisor;

        return String.format("%d / %d = %d", dividend, divisor, result);
    }
}

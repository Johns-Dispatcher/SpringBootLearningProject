package pers.johns.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * ClassName    : JSONController
 * Description  : TODO
 * CreateTime   : 2024/6/6 0:25
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/json")
public class JSONController {

    @GetMapping("/message")
    public String jsonMessage() {
        return "Random: " + new Random().nextInt(5000);
    }
}

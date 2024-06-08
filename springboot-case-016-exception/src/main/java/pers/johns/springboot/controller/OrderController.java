package pers.johns.springboot.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.johns.springboot.model.pojo.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName    : OrderController
 * Description  :
 * CreateTime   : 2024/6/8 11:11
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/add")
    public Map<String, Object> addOrder(
            @RequestBody
            @Validated
            Order order
    ) {
        Map<String, Object> map = new HashMap<>();

        map.put("order", order);

        return map;
    }
}

package pers.johns.springboot.controller;

import org.springframework.web.bind.annotation.*;
import pers.johns.springboot.model.pojo.DeviceInfo;

/**
 * ClassName    : DeviceController
 * Description  :
 * CreateTime   : 2024/6/7 15:07
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/device")
public class DeviceController {

    @PostMapping("/add")
    public String addDevice(@RequestParam("device") DeviceInfo deviceInfo) {
        return deviceInfo.toString();
    }
}

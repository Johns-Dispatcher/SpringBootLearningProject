package pers.johns.springboot.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : DeviceInfo
 * Description  : 存储数据格式为 item1;item2;item3;item;item5
 * CreateTime   : 2024/6/7 14:53
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
}

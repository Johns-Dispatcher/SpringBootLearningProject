package pers.johns.springboot.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : Todo
 * Description  :
 * CreateTime   : 2024/6/8 22:38
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}

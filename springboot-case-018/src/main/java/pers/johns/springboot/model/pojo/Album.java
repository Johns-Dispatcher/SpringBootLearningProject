package pers.johns.springboot.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : Album
 * Description  :
 * CreateTime   : 2024/6/9 19:38
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    private Integer userId;
    private Integer id;
    private String title;

}

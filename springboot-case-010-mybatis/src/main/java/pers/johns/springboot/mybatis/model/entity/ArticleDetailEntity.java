package pers.johns.springboot.mybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : ArticleDetailEntity
 * Description  :
 * CreateTime   : 2024/6/4 16:09
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailEntity {
    private Integer id;
    private Integer articleId;
    private String content;
}

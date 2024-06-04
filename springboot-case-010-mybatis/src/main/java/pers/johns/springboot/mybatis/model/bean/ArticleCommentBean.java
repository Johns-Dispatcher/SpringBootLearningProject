package pers.johns.springboot.mybatis.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : ArticleCommentBean
 * Description  :
 * CreateTime   : 2024/6/4 19:00
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentBean {
    private Integer id;
    private Integer articleId;
    private String content;
}

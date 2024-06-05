package pers.johns.springboot.transcation.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : ArticleDetail
 * Description  : 对应数据库表article_detail的POJO类
 * CreateTime   : 2024/6/5 15:52
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetail {
    private Integer id;
    private Integer articleId;
    private String content;
}

package pers.johns.springboot.blog.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : ArticleDetailPO
 * <br/>
 * Description  : 文章细节持久对象
 * <br/>
 * CreateTime   : 2024/6/10 10:39
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailPO {
    private Integer id;
    private Integer articleId;
    private String content;
}

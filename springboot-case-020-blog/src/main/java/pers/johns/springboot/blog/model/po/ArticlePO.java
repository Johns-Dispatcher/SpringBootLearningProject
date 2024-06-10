package pers.johns.springboot.blog.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName    : ArticlePO
 * <br/>
 * Description  : 文章持久对象
 * <br/>
 * CreateTime   : 2024/6/10 10:38
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private ArticleDetailPO articleDetail;
}

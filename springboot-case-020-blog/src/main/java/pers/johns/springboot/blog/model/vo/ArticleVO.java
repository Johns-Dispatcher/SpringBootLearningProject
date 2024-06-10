package pers.johns.springboot.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.johns.springboot.blog.model.po.ArticleDetailPO;

import java.time.LocalDateTime;

/**
 * ClassName    : ArticleVO
 * <br/>
 * Description  : 文章视图对象
 * <br/>
 * CreateTime   : 2024/6/10 11:18
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private ArticleDetailPO articleDetail;
    private Boolean checked;
}

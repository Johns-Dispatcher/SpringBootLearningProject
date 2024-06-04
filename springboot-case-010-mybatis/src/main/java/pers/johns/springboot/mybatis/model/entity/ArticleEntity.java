package pers.johns.springboot.mybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName    : ArticleEntity
 * Description  :
 * CreateTime   : 2024/6/4 16:07
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private ArticleDetailEntity articleDetail;
}

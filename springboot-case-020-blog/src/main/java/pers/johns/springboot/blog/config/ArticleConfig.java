package pers.johns.springboot.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName    : ArticleConfig
 * <br/>
 * Description  : 文章相关配置属性
 * <br/>
 * CreateTime   : 2024/6/10 11:02
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@ConfigurationProperties(prefix = "article")
@Data
public class ArticleConfig {

    private Integer lowReadCount;
    private Integer topShowRows;
}

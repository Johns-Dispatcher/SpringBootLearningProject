package pers.johns.springboot.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pers.johns.springboot.blog.config.ArticleConfig;

/**
 * ClassName    : BlogApplication
 * <br/>
 * Description  : 启动类
 * <br/>
 * CreateTime   : 2024/6/10 9:37
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@MapperScan("pers.johns.springboot.blog.mapper")
@EnableConfigurationProperties({
        ArticleConfig.class
})
@SpringBootApplication
@EnableTransactionManagement
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}

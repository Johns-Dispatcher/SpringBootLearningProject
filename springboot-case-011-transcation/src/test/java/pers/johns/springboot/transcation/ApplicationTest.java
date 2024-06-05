package pers.johns.springboot.transcation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.johns.springboot.transcation.model.pojo.Article;
import pers.johns.springboot.transcation.service.ArticleService;

import java.time.LocalDateTime;

/**
 * ClassName    : ApplicationTest
 * Description  :
 * CreateTime   : 2024/6/5 16:32
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testPostArticle() {
        Article article = new Article();

        article.setUserId(305);
        article.setTitle("SpringBoot Transaction");
        article.setSummary("Transaction Important");
        article.setReadCount(20);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        boolean result = articleService.postNewArticle(article, "Spring Boot 是个好东西");

        System.out.println(result ? "发布成功" : "发布失败");
    }

    @Test
    public void testPostTransaction() {
        Article article = new Article();

        article.setUserId(31);
        article.setTitle("SpringBoot Transaction");
        article.setSummary("Transaction Important");
        // 阅读量为0 模拟异常 测试事务管理
        article.setReadCount(0);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        boolean result = articleService.postNewArticle(article, "Spring Boot 是个好东西");

        System.out.println(result ? "发布成功" : "发布失败");
    }
}

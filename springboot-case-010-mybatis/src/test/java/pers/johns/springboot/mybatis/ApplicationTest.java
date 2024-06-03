package pers.johns.springboot.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.johns.springboot.mybatis.mapper.ArticleMapper;
import pers.johns.springboot.mybatis.model.pojo.Article;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testMapper() {
        Article article = articleMapper.selectById(1);
        System.out.println(article);
    }

    @Test
    public void testInsert() {

        Article article = new Article();

        article.setUserId(new Random().nextInt(500));
        article.setTitle("SpringBoot Application");
        article.setSummary("Spring");
        article.setReadCount(100);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        int count = articleMapper.insertArticle(article);

        System.out.println(count);
    }

    @Test
    public void testUpdateReadCount() {
        int count = articleMapper.updateReadCount(3, 301);

        System.out.println(count);
    }

    @Test
    public void testDelete() {
        int count = articleMapper.deleteArticle(3);

        System.out.println(count);
    }
}

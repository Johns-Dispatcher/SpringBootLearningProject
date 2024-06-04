package pers.johns.springboot.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.johns.springboot.mybatis.dao.ArticleDao;
import pers.johns.springboot.mybatis.mapper.ArticleMapper;
import pers.johns.springboot.mybatis.model.pojo.Article;
import pers.johns.springboot.mybatis.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 测试MyBatis查询
     */
    @Test
    public void testMapper() {
        Article article = articleMapper.selectById(1);
        System.out.println(article);
    }

    /**
     * 测试MyBatis新增
     */
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

    /**
     * 测试MyBatis更新
     */
    @Test
    public void testUpdateReadCount() {
        int count = articleMapper.updateReadCount(3, 301);

        System.out.println(count);
    }

    /**
     * 测试MyBatis删除
     */
    @Test
    public void testDelete() {
        int count = articleMapper.deleteArticle(3);

        System.out.println(count);
    }

    /**
     * 使用结果映射集
     */
    @Test
    public void testResultMap() {
        Article article = articleDao.selectById(2);
        System.out.println(article);

        List<Article> articles = articleDao.selectByUserId(1331);
        System.out.println(articles);
    }

    /**
     * 测试SQLProvider
     */
    @Test
    public void testSqlProvider() {
        Article article = articleRepository.selectById(1);
        System.out.println(article);

        int count = articleRepository.updateTime(2, LocalDateTime.now());
        System.out.println(count);
    }

    /**
     * 测试SQLProvider 新增操作
     */
    @Test
    public void testSqlProviderInsert() {
        Article article = new Article();

        article.setUserId(3001);
        article.setTitle("SQLProvider Usage");
        article.setSummary("SQLProvider is easy");
        article.setReadCount(10);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        int count = articleRepository.insertArticle(article);

        System.out.println(count);
    }

    /**
     * 测试SQLProvider 删除操作
     */
    @Test
    public void testSqlProviderDelete() {
        int count = articleRepository.deleteArticle(4);

        System.out.println(count);
    }


}

package pers.johns.springboot.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pers.johns.springboot.jdbc.model.pojo.Article;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName    : ApplicationTest
 * Description  :
 * CreateTime   : 2024/6/3 16:39
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 测试JDBC模板类
     */
    @Test
    public void testJdbcTemplate() {
        String sql = "select count(*) from article";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /**
     * 测试带参数的SQL语句
     */
    @Test
    public void testParaQuery() {
        String sql = "select * from article where id = ?";
        Article article = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Article.class), 1);
        System.out.println(article);
    }

    /**
     * 测试自定义RowMapper对象
     */
    @Test
    public void testRowMapper() {
        String sql = "select * from article where id = ?";
        Article article = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            System.out.println("rs = " + rs);
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

            return new Article(id, userId, title, summary, readCount, createTime, updateTime);
        }, 1);
        System.out.println(article);
    }

    /**
     * 测试查询列表方法
     */
    @Test
    public void testQueryList() {
        String sql = "select * from article";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        articles.forEach(article -> {
            article.forEach((articleProperty, propertyValue) -> {
                System.out.printf("Property: %s, Value: %s%n", articleProperty, propertyValue);
            });
            System.out.println("====");
        });
    }

    /**
     * 测试Update语句更新数据库条目
     */
    @Test
    public void testUpdate() {
        String sql = "update article set title = ? where id = ?";
        int count = jdbcTemplate.update(sql, "JVM 001", 2);
        System.out.println("影响记录条数" + count);
    }


    /***
     * 使用命名参数模板类 NameParameterJdbcTemplate
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "select count(*) from article where user_id=:uid and read_count >:num";

        Map<String, Object> params = new HashMap<>();

        params.put("uid", 2101);
        params.put("num", 10);

        Long count = namedParameterJdbcTemplate.queryForObject(sql, params, Long.class);
        System.out.println(count);
    }

}

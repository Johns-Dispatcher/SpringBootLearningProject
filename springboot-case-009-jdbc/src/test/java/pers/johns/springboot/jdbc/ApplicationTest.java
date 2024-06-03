package pers.johns.springboot.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.johns.springboot.jdbc.model.pojo.Article;

import java.sql.Timestamp;

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
}

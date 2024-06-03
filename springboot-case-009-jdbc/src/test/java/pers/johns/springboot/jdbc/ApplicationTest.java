package pers.johns.springboot.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

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

    @Test
    public void testJdbcTemplate() {
        String sql = "select count(*) from article";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

}

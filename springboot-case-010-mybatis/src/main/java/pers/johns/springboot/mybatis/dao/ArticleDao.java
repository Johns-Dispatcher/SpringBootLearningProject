package pers.johns.springboot.mybatis.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.johns.springboot.mybatis.model.pojo.Article;

import java.util.List;

/**
 * InterfaceName : ArticleDao
 * Description   : 测试ResultMap的Mapper接口
 * CreateTime    : 2024/6/4 10:07
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleDao {

    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where user_id = #{userId}
            """)
    @Results(id = "ArticleMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<Article> selectByUserId(Integer userId);

    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where id = #{id}
            """)
    @ResultMap("ArticleDaoMap")
    Article selectById(Integer id);
}

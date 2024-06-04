package pers.johns.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import pers.johns.springboot.mybatis.model.pojo.Article;

/**
 * InterfaceName : ArticleMapper
 * Description   : 普通的Mapper接口
 * CreateTime    : 2024/6/3 22:02
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleMapper {

    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where id = #{articleId}
            """)
    @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "user_id", property = "userId"), @Result(column = "title", property = "title"), @Result(column = "summary", property = "summary"), @Result(column = "read_count", property = "readCount"), @Result(column = "create_time", property = "createTime"), @Result(column = "update_time", property = "updateTime")})
    Article selectById(@Param("articleId") Integer id);

    @Insert("""
            insert into article(user_id, title, summary, read_count, create_time, update_time) \
            VALUES (#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    int insertArticle(Article article);

    @Update("""
            update article \
            set read_count = #{readCount} \
            where id = #{id}
            """)
    int updateReadCount(Integer id, Integer readCount);

    @Delete("""
            delete from article \
            where id = #{id}
            """)
    int deleteArticle(Integer id);
}

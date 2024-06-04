package pers.johns.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import pers.johns.springboot.mybatis.model.entity.ArticleDetailEntity;
import pers.johns.springboot.mybatis.model.entity.ArticleEntity;

/**
 * InterfaceName : ArticleOne2OneMapper
 * Description   : 测试使用@One注解完成MyBatis高级映射
 * CreateTime    : 2024/6/4 16:11
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleOne2OneMapper {

    @Select("""
            select id, article_id, content \
            from article_detail \
            where article_id = #{articleId}
            """)
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    ArticleDetailEntity selectDetail(Integer articleId);

    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where id = #{id}
            """)
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "articleDetail", one = @One(
                    select = "pers.johns.springboot.mybatis.mapper.ArticleOne2OneMapper.selectDetail",
                    fetchType = FetchType.LAZY
            ))
    })
    ArticleEntity selectArticle(Integer id);
}

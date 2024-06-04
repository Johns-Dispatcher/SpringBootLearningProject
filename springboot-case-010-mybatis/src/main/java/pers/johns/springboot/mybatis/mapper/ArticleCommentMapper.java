package pers.johns.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import pers.johns.springboot.mybatis.model.bean.ArticleBean;
import pers.johns.springboot.mybatis.model.bean.ArticleCommentBean;

import java.util.List;

/**
 * InterfaceName : ArticleCommentMapper
 * Description   :
 * CreateTime    : 2024/6/4 19:04
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleCommentMapper {

    @Select("""
            select id, article_id, content \
            from comment
            where article_id = #{articleId}
            """)
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    List<ArticleCommentBean> selectCommentsByArticleId(Integer articleId);

    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where id = #{id}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "comments", many = @Many(
                    select = "pers.johns.springboot.mybatis.mapper.ArticleCommentMapper.selectCommentsByArticleId",
                    fetchType = FetchType.LAZY
            ))
    })
    ArticleBean selectArticleWitchCommentsById(Integer id);
}

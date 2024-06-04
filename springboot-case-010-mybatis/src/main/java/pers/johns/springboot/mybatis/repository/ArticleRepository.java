package pers.johns.springboot.mybatis.repository;

import org.apache.ibatis.annotations.*;
import pers.johns.springboot.mybatis.model.pojo.Article;
import pers.johns.springboot.mybatis.provider.SqlProvider;

import java.time.LocalDateTime;

/**
 * InterfaceName : ArticleRepository
 * Description   : 测试SqlProvider的Mapper接口
 * CreateTime    : 2024/6/4 12:57
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleRepository {

    /**
     * 仅用于定义ResultMap 不执行SQL语句
     *
     * @return null
     */
    @Select("")
    @Results(id = "ArticleMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    Article articleRepository();

    @SelectProvider(type = SqlProvider.class, method = "selectArticle")
    @ResultMap("ArticleMap")
    Article selectById(Integer id);

    @UpdateProvider(type = SqlProvider.class, method = "updateArticleTime")
    int updateTime(Integer id, LocalDateTime newTime);

    @InsertProvider(type = SqlProvider.class, method = "insertArticle")
    int insertArticle(Article article);

    @DeleteProvider(type = SqlProvider.class, method = "deleteArticleById")
    int deleteArticle(Integer id);
}

package pers.johns.springboot.transcation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import pers.johns.springboot.transcation.model.pojo.Article;
import pers.johns.springboot.transcation.model.pojo.ArticleDetail;

/**
 * InterfaceName : ArticleMapper
 * Description   : 文章相关的Mapper接口
 * CreateTime    : 2024/6/5 15:54
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleMapper {

    /**
     * 新增文章
     *
     * @param article 文章对象
     * @return 数据库更新条数
     */
    @Insert("""
            insert into article(user_id, title, summary, read_count, create_time, update_time) \
            values(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertArticle(Article article);

    /**
     * 新增文章细节
     *
     * @param articleDetail 文章细节对象
     * @return 数据库更新条数
     */
    @Insert("""
            insert into article_detail(article_id, content) \
            values(#{articleId}, #{content})
            """)
    int insertArticleDetail(ArticleDetail articleDetail);
}

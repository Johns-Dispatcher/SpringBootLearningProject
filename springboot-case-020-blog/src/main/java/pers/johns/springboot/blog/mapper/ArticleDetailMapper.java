package pers.johns.springboot.blog.mapper;

import org.apache.ibatis.annotations.*;
import pers.johns.springboot.blog.model.po.ArticleDetailPO;

/**
 * InterfaceName : ArticleDetailMapper
 * <br/>
 * Description   : 用于操作表 article_detail 的接口
 * <br/>
 * CreateTime    : 2024/6/10 10:43
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleDetailMapper {

    /**
     * 根据文章ID查询文章详情内容
     *
     * @param articleId 文章ID
     * @return 文章详情对象
     */
    @Select("""
            select id, article_id, content \
            from article_detail \
            where article_id = #{articleId}
            """)
    @Results(id = "ArticleDetailBaseMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    ArticleDetailPO selectByArticleId(Integer articleId);

    /**
     * 修改文章详情
     *
     * @param articleDetailPO 文章详情对象
     * @return 数据库更新条数
     */
    @Update("""
            update article_detail \
            set content = #{content} \
            where id = #{id}
            """)
    int modifyArticleDetail(ArticleDetailPO articleDetailPO);

    /**
     * 新增文章详情
     *
     * @param articleDetailPO 文章详情对象
     * @return 数据库更新条数
     */
    @Insert("""
            insert into article_detail(article_id, content) \
            values(#{articleId}, #{content})
            """)
    int insertArticleDetail(ArticleDetailPO articleDetailPO);

    /**
     * 删除文章详情
     *
     * @param articleId 文章ID
     * @return 数据库更新条数
     */
    @Delete("""
            delete from article_detail where article_id = #{id};
            """)
    int deleteArticleDetail(Integer articleId);
}

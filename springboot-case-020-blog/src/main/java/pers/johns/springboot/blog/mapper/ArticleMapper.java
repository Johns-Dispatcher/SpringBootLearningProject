package pers.johns.springboot.blog.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import pers.johns.springboot.blog.model.po.ArticlePO;

import java.util.List;

/**
 * InterfaceName : ArticleMapper
 * <br/>
 * Description   : 用于操作表 article 的接口
 * <br/>
 * CreateTime    : 2024/6/10 10:43
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleMapper {

    /**
     * 查询热点文章
     *
     * @param lowReadCount 最少阅读量
     * @param topShowRows  最大显示行数
     * @return 热点文章列表
     */
    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where read_count >= #{lowReadCount} \
            order by read_count desc \
            limit #{topShowRows}
            """)
    @Results(id = "ArticleBaseMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "articleDetail", one = @One(
                    select = "pers.johns.springboot.blog.mapper.ArticleDetailMapper.selectByArticleId",
                    fetchType = FetchType.LAZY
            ))
    })
    List<ArticlePO> topSelectSortByReadCount(Integer lowReadCount, Integer topShowRows);

    /**
     * 查询指定文章
     *
     * @param id 文章ID
     * @return 文章对象
     */
    @Select("""
            select id, user_id, title, summary, read_count, create_time, update_time \
            from article \
            where id = #{id}
            """)
    @ResultMap("ArticleBaseMap")
    ArticlePO selectById(Integer id);

    /**
     * 修改指定文章
     *
     * @param articlePO 文章对象
     * @return 数据库更新条数
     */
    @Update("""
            update article \
            set title = #{title}, summary = #{summary}, update_time = #{updateTime} \
            where id = #{id}
            """)
    int modifyArticle(ArticlePO articlePO);

    /**
     * 新增文章
     *
     * @param articlePO 文章对象
     * @return 数据库更新条数
     */
    @Insert("""
            insert into article(user_id, title, summary, read_count, create_time, update_time) \
            values(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertArticle(ArticlePO articlePO);

    /**
     * 删除文章
     *
     * @param id 文章ID
     * @return 数据库更新条数
     */
    @Delete("""
            delete from article where id = #{id}
            """)
    int deleteArticle(Integer id);

}

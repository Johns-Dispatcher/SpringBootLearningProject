package pers.johns.springboot.mybatis.provider;

/**
 * ClassName    : SqlProvider
 * Description  : 为Mapper接口提供SQL语句
 * CreateTime   : 2024/6/4 12:53
 *
 * @author : JohnS
 * @version : 1.0
 */
public class SqlProvider {

    /**
     * 私有化构造 该类不需要实例
     */
    private SqlProvider() {
    }

    /**
     * 按照ID查询指定文章信息
     *
     * @return 查询文章信息的SQL语句
     */
    public static String selectArticle() {
        return """
                select * from article \
                where id = #{id}
                """;
    }

    /**
     * 更新指定ID文章的更新时间
     * @return 更新文章的SQL语句
     */
    public static String updateArticleTime() {
        return """
                update article \
                set update_time = #{newTime} \
                where id = #{id}
                """;
    }

    /**
     * 新增文章信息
     *
     * @return 新增文章的SQL语句
     */
    public static String insertArticle() {
        return """
                insert into article(user_id, title, summary, read_count, create_time, update_time) \
                values(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
                """;
    }

    /**
     * 根据ID删除指定文章
     *
     * @return 删除文章的SQL语句
     */
    public static String deleteArticleById() {
        return """
                delete from article \
                where id = #{id}
                """;
    }
}

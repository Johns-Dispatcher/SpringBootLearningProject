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

    private SqlProvider() {
    }

    public static String selectArticle() {
        return """
                select * from article \
                where id = #{id}
                """;
    }

    public static String updateArticleTime() {
        return """
                update article \
                set update_time = #{newTime} \
                where id = #{id}
                """;
    }
}

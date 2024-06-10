package pers.johns.springboot.blog.model.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : ArticleParam
 * <br/>
 * Description  : 接收请求数据 并进行验证
 * <br/>
 * CreateTime   : 2024/6/10 15:57
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleParam {

    public static interface AddArticle {
    }

    ;

    public static interface EditArticle {
    }

    ;

    @NotNull(message = "修改时需要提供ID", groups = EditArticle.class)
    @Min(value = 1, message = "文章的ID应当大于{value}", groups = EditArticle.class)
    private Integer id;

    @NotNull(message = "新增时需要提供用户ID", groups = AddArticle.class)
    @Min(value = 1, message = "用户ID应当大于{value}", groups = AddArticle.class)
    private Integer userId;

    @NotBlank(message = "文章标题不应该为空", groups = {
            EditArticle.class,
            AddArticle.class
    })
    @Size(min = 2, max = 20, message = "文章标题的字数应该位于{min}到{max}之间", groups = {
            EditArticle.class,
            AddArticle.class
    })
    private String title;

    @NotBlank(message = "文章副标题不应该为空", groups = {
            EditArticle.class,
            AddArticle.class
    })
    @Size(min = 5, max = 30, message = "文章标题的字数应该位于{min}到{max}之间", groups = {
            EditArticle.class,
            AddArticle.class
    })
    private String summary;

    @NotBlank(message = "文章内容不应该为空", groups = {
            EditArticle.class,
            AddArticle.class
    })
    private String content;
}

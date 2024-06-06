package pers.johns.springboot.web.model.pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName    : Article
 * Description  : 文章类 使用数据验证注解
 * CreateTime   : 2024/6/6 17:52
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    /**
     * 分组接口 新增文章
     */
    public static interface AddArticle {
    }

    ;

    /**
     * 分组接口 修改文章
     */
    public static interface EditArticle {
    }

    ;

    @NotNull(groups = EditArticle.class, message = "修改文章需要指定文章ID")
    @Min(groups = EditArticle.class, value = 1, message = "ID应当大于0")
    private Integer id;

    @NotNull(groups = {
            EditArticle.class,
            AddArticle.class
    }, message = "作者不能为空")
    private Integer userId;

    @NotBlank(groups = {
            EditArticle.class,
            AddArticle.class
    }, message = "文章必须存在标题")
    @Size(groups = {
            EditArticle.class,
            AddArticle.class
    }, min = 3, max = 30, message = "标题需要在3~30字符之间")
    private String title;

    @NotBlank(groups = {
            EditArticle.class,
            AddArticle.class
    }, message = "副标题必须存在")
    @Size(groups = {
            EditArticle.class,
            AddArticle.class
    }, min = 3, max = 20, message = "副标题需要在3~20字符之间")
    private String summary;

    @DecimalMin(groups = {
            EditArticle.class,
            AddArticle.class
    }, value = "0", message = "阅读量不能小于零")
    private Integer readCount;

    @Email(groups = {
            EditArticle.class,
            AddArticle.class
    }, message = "邮箱格式不正确")
    private String emil;
}

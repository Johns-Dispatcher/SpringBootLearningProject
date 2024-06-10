package pers.johns.springboot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName    : ArticleViewController
 * <br/>
 * Description  : 文章视图控制器 用于控制视图跳转
 * <br/>
 * CreateTime   : 2024/6/10 13:38
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@Controller
@RequestMapping("/article")
public class ArticleViewController {

    /**
     * 跳转至查询页面
     *
     * @param id    文章ID 携带至请求域
     * @param model 用于数据绑定的 Model 对象
     * @return 查询的逻辑视图名称
     */
    @GetMapping("/query/{id}")
    public String toQuery(@PathVariable Integer id, Model model) {
        model.addAttribute("articleId", id);
        return "/blog/detail";
    }

    /**
     * 跳转修改页面
     *
     * @param id    文章ID 携带至请求域
     * @param model 用于数据绑定的 Model 对象
     * @return 修改的逻辑视图名称
     */
    @GetMapping("/modify/{id}")
    public String toModify(@PathVariable Integer id, Model model) {
        model.addAttribute("articleId", id);
        return "/blog/modify";
    }

    /**
     * 跳转新增发布页面
     *
     * @return 新增页面的逻辑视图名称
     */
    @GetMapping("/add")
    public String toAdd() {
        return "/blog/add";
    }
}

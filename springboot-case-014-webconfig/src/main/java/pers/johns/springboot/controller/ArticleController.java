package pers.johns.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName    : ArticleController
 * Description  :
 * CreateTime   : 2024/6/7 16:23
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @PostMapping("/post")
    public String postArticle() {
        return "发布新文章";
    }

    @PostMapping("/edit")
    public String editArticle() {
        return "修改文章";
    }

    @GetMapping("/query")
    public String queryArticle() {
        return "查询文章";
    }
}

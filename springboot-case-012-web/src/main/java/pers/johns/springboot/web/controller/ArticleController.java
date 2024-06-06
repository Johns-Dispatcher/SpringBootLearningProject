package pers.johns.springboot.web.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.johns.springboot.web.model.pojo.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName    : ArticleController
 * Description  : 测试验证
 * CreateTime   : 2024/6/6 18:02
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @PostMapping("/post")
    public Map<String, Object> postArticle(
            @Validated(Article.AddArticle.class)
            @RequestBody
            Article article,
            BindingResult bindingResult
    ) {
        Map<String, Object> map = new HashMap<>();

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            int count = 1;

            for (FieldError fieldError : fieldErrors) {
                map.put(count + "." + fieldError.getField(), fieldError.getDefaultMessage());
                count++;
            }
        }

        return map;
    }

    @PostMapping("/edit")
    public Map<String, Object> editArticle(
            @Validated(Article.EditArticle.class)
            @RequestBody
            Article article,
            BindingResult bindingResult
    ) {
        Map<String, Object> map = new HashMap<>();

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            int count = 1;

            for (FieldError fieldError : fieldErrors) {
                map.put(count + "." + fieldError.getField(), fieldError.getDefaultMessage());
                count++;
            }
        }

        return map;
    }
}

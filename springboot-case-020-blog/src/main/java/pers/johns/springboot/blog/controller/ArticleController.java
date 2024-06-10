package pers.johns.springboot.blog.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.johns.springboot.blog.model.param.ArticleParam;
import pers.johns.springboot.blog.model.po.ArticlePO;
import pers.johns.springboot.blog.model.vo.ArticleVO;
import pers.johns.springboot.blog.service.ArticleService;

import java.util.List;

/**
 * ClassName    : ArticleController
 * <br/>
 * Description  : 文章控制器 处理AJAX请求
 * <br/>
 * CreateTime   : 2024/6/10 11:11
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 查询热门文章数据 用于主页的数据展示
     *
     * @return 文章列表
     */
    @GetMapping("/")
    public List<ArticleVO> showHotArticle() {
        List<ArticlePO> articles = articleService.queryTopArticle();
        return BeanUtil.copyToList(articles, ArticleVO.class);
    }

    /**
     * 用于查询文章详细信息
     *
     * @param id 文章主键ID
     * @return 文章对象
     */
    @GetMapping("/{id}")
    public ArticleVO queryById(@PathVariable Integer id) {
        ArticlePO article = articleService.queryById(id);
        return BeanUtil.copyProperties(article, ArticleVO.class);
    }

    /**
     * 用于修改文章详细信息
     *
     * @param articleParam 请求体携带的数据
     * @return 数据库更新记录
     */
    @PutMapping("/")
    public int modifyById(
            @Validated(ArticleParam.EditArticle.class)
            @RequestBody
            ArticleParam articleParam
    ) {
        return articleService.modifyById(articleParam);
    }

    /**
     * 用于发布新文章
     *
     * @param articleParam 请求体携带的数据
     * @return 数据库更新记录
     */
    @PostMapping("/")
    public int postArticle(
            @Validated(ArticleParam.AddArticle.class)
            @RequestBody
            ArticleParam articleParam
    ) {
        return articleService.postArticle(articleParam);
    }

    /**
     * 用于删除文章
     *
     * @param id 文章主键ID
     * @return 数据库更新记录
     */
    @DeleteMapping("/{id}")
    public int deleteArticle(@PathVariable Integer id) {
        return articleService.deleteArticle(id);
    }
}

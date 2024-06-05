package pers.johns.springboot.transcation.service;

import pers.johns.springboot.transcation.model.pojo.Article;

/**
 * InterfaceName : ArticleService
 * Description   : 文章业务接口
 * CreateTime    : 2024/6/5 16:07
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleService {

    /**
     * 发布新文章
     *
     * @param article 文章相关信息
     * @param content 文章具体内容
     * @return 是否成功发布
     */
    boolean postNewArticle(Article article, String content);
}

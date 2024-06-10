package pers.johns.springboot.blog.service;

import pers.johns.springboot.blog.model.param.ArticleParam;
import pers.johns.springboot.blog.model.po.ArticlePO;
import pers.johns.springboot.blog.model.vo.ArticleVO;

import java.util.List;

/**
 * InterfaceName : ArticleService
 * <br/>
 * Description   : 文章业务接口
 * <br/>
 * CreateTime    : 2024/6/10 10:58
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */
public interface ArticleService {

    /**
     * 查询热点文章
     *
     * @return 热点文章列表
     */
    List<ArticlePO> queryTopArticle();

    /**
     * 查询指定文章
     *
     * @param id 文章ID
     * @return 文章对象
     */
    ArticlePO queryById(Integer id);

    /**
     * 修改指定文章
     *
     * @param id        文章ID
     * @param articleParam 文章对象
     * @return 数据库更新条数
     */
    int modifyById(Integer id, ArticleParam articleParam);

    /**
     * 发布新文章
     *
     * @param articleParam 文章对象
     * @return 数据库更新条数
     */
    int postArticle(ArticleParam articleParam);

    /**
     * 删除指定文章
     *
     * @param id 文章ID
     * @return 数据库更新条数
     */
    int deleteArticle(Integer id);
}

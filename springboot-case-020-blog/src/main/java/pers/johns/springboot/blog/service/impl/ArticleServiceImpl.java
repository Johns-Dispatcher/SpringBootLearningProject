package pers.johns.springboot.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.johns.springboot.blog.config.ArticleConfig;
import pers.johns.springboot.blog.exception.ArticleException;
import pers.johns.springboot.blog.mapper.ArticleDetailMapper;
import pers.johns.springboot.blog.mapper.ArticleMapper;
import pers.johns.springboot.blog.model.param.ArticleParam;
import pers.johns.springboot.blog.model.po.ArticleDetailPO;
import pers.johns.springboot.blog.model.po.ArticlePO;
import pers.johns.springboot.blog.model.vo.ArticleVO;
import pers.johns.springboot.blog.service.ArticleService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName    : ArticleServiceImpl
 * <br/>
 * Description  : 文件业务接口实现
 * <br/>
 * CreateTime   : 2024/6/10 10:59
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;
    private final ArticleConfig articleConfig;
    private final ArticleDetailMapper articleDetailMapper;

    @Override
    public List<ArticlePO> queryTopArticle() {
        return articleMapper.topSelectSortByReadCount(articleConfig.getLowReadCount(), articleConfig.getLowReadCount());
    }

    @Override
    public ArticlePO queryById(Integer id) {
        return articleMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int modifyById(Integer id, ArticleParam articleParam) {
        ArticlePO articlePO = new ArticlePO();

        articlePO.setId(id);
        articlePO.setUserId(articleParam.getUserId());
        articlePO.setTitle(articleParam.getTitle());
        articlePO.setSummary(articleParam.getSummary());
        articlePO.setUpdateTime(LocalDateTime.now());

        int count = articleMapper.modifyArticle(articlePO);

        ArticleDetailPO articleDetailPO = new ArticleDetailPO();

        articleDetailPO.setArticleId(id);
        articleDetailPO.setContent(articleParam.getContent());

        count += articleDetailMapper.modifyArticleDetail(articleDetailPO);

        if (count != 2) {
            throw new ArticleException(HttpStatus.INTERNAL_SERVER_ERROR, "更新数据库失败，请联系管理员");
        }

        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int postArticle(ArticleParam articleParam) {
        ArticlePO articlePO = new ArticlePO();

        articlePO.setUserId(articleParam.getUserId());
        articlePO.setTitle(articleParam.getTitle());
        articlePO.setSummary(articleParam.getSummary());
        articlePO.setReadCount(15);
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());

        int count = articleMapper.insertArticle(articlePO);

        ArticleDetailPO articleDetail = new ArticleDetailPO();

        articleDetail.setArticleId(articlePO.getId());
        articleDetail.setContent(articleParam.getContent());

        count += articleDetailMapper.insertArticleDetail(articleDetail);

        if (count != 2) {
            throw new ArticleException(HttpStatus.INTERNAL_SERVER_ERROR, "未能成功发布，请联系管理员");
        }

        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteArticle(Integer id) {
        int count = articleMapper.deleteArticle(id);
        count += articleDetailMapper.deleteArticleDetail(id);

        if (count != 2) {
            throw new ArticleException(HttpStatus.INTERNAL_SERVER_ERROR, "未能成功删除文章，请联系管理员");
        }

        return count;
    }
}

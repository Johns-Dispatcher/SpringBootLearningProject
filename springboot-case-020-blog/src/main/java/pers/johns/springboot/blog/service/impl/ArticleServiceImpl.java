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

    @Transactional
    @Override
    public int modifyById(Integer id, ArticleVO articleVO) {
        ArticlePO articlePO = BeanUtil.copyProperties(articleVO, ArticlePO.class);
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setId(id);

        int count = articleMapper.modifyArticle(articlePO);
        count += articleDetailMapper.modifyArticleDetail(articlePO.getArticleDetail());

        if (count != 2) {
            throw new ArticleException(HttpStatus.INTERNAL_SERVER_ERROR, "更新数据库失败，请联系管理员");
        }

        return count;
    }

    @Transactional
    @Override
    public int postArticle(ArticleVO articleVO) {
        ArticlePO articlePO = BeanUtil.copyProperties(articleVO, ArticlePO.class);
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setReadCount(15);

        int count = articleMapper.insertArticle(articlePO);

        ArticleDetailPO articleDetail = articlePO.getArticleDetail();
        articleDetail.setArticleId(articlePO.getId());

        count += articleDetailMapper.insertArticleDetail(articleDetail);

        if (count != 2) {
            throw new ArticleException(HttpStatus.INTERNAL_SERVER_ERROR, "未能成功发布，请联系管理员");
        }

        return count;
    }

    @Transactional
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

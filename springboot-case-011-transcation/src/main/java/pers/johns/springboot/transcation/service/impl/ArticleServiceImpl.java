package pers.johns.springboot.transcation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.johns.springboot.transcation.mapper.ArticleMapper;
import pers.johns.springboot.transcation.model.pojo.Article;
import pers.johns.springboot.transcation.model.pojo.ArticleDetail;
import pers.johns.springboot.transcation.service.ArticleService;

/**
 * ClassName    : ArticleServiceImpl
 * Description  : 文章业务实现类
 * CreateTime   : 2024/6/5 16:09
 *
 * @author : JohnS
 * @version : 1.0
 */

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    @Transactional
    @Override
    public boolean postNewArticle(Article article, String content) {

        int count = articleMapper.insertArticle(article);

        if (article.getReadCount() < 1) {
            throw new RuntimeException("阅读数最小为1");
        }

        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleId(article.getId());
        articleDetail.setContent(content);

        count += articleMapper.insertArticleDetail(articleDetail);

        return count == 2;
    }
}

package top.byteinfo.springmall.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.byteinfo.springmall.web.model.cdblog.dao.ArticleDao;
import top.byteinfo.springmall.web.model.cdblog.entity.Article;
import top.byteinfo.springmall.web.service.IOArticleService;

/**
 *
 */
@Service("service")
public class IOArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements IOArticleService {
    @Override
    public String se2(){
        Article Article = this.baseMapper.selectById(11);
        System.out.println(Article.toString());
        return Article.toString();
    }

}

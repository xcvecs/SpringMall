package top.byteinfo.springmall.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.byteinfo.springmall.mbg.entity.TbArticle;
import top.byteinfo.springmall.web.model.blog.dao.TbArticleDao;
import top.byteinfo.springmall.web.service.UtilsTbArticleService;
@Service
public class UtilsTbArticleServiceImpl extends ServiceImpl<TbArticleDao, TbArticle> implements UtilsTbArticleService {
    @Override
    public String se1(){
        TbArticle tbArticle = this.baseMapper.selectById(1);
        System.out.println(tbArticle.toString());
        return tbArticle.toString();
    }
}

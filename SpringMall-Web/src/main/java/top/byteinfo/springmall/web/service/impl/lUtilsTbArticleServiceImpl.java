package top.byteinfo.springmall.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.byteinfo.springmall.mbg.entity.TbArticle;
import top.byteinfo.springmall.web.model.blog.dao.TbArticleDao;
import top.byteinfo.springmall.web.service.lUtilsTbArticleService;
@Service
public class lUtilsTbArticleServiceImpl extends ServiceImpl<TbArticleDao, TbArticle> implements lUtilsTbArticleService {
    @Override
    public String se1(){
        TbArticle tbArticle = this.baseMapper.selectById(1);
        System.out.println(tbArticle.toString());
        return tbArticle.toString();
    }
}

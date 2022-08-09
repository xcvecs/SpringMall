package top.byteinfo.springmall.web.model.cdblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.byteinfo.springmall.web.model.cdblog.entity.Article;

@Repository
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
}

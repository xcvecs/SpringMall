package top.byteinfo.springmall.web.model.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.byteinfo.springmall.mbg.entity.TbArticle;
@Repository
@Mapper
public interface TbArticleDao extends BaseMapper<TbArticle> {
}

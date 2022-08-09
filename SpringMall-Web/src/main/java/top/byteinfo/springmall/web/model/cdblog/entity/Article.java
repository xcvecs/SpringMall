package top.byteinfo.springmall.web.model.cdblog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bl_article")
public class Article {
    private Integer id;

    private Integer userAuthId;

    private Integer categoryId;

    private String articleCover;

    private String articleTitle;

    private String articleContent;
}
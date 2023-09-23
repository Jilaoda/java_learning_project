package com.blog.personalblog.service;


import com.blog.personalblog.bo.ArticleBO;
import com.blog.personalblog.bo.ArticleInsertBO;
import com.blog.personalblog.entity.Article;
import com.blog.personalblog.vo.ArticleVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-27 11:24:32
 * @description 文章服务接口,init为初始化数据并建立缓存,加快速度
 */
public interface ArticleService {

    /**
     * @details: 初始化数据并建立缓存,加快速度
     * @date: 2023/5/27
     * @Param: []
     * @return: void
     */
    void init();

    /**
     * @details: 获取所有的文章（分页）
     * @date: 2023/5/27
     * @Param: [articleBO]
     * @return: List<Article>
     */
    List<Article> getArticlePage(ArticleBO articleBO);

    /**
     * @details: 新建文章
     * @date: 2023/5/27
     * @Param: [article]
     * @return: void
     */
    void saveArticle(Article article);

    /**
     * @details: 修改文章
     * @date: 2023/5/27
     * @Param: [article]
     * @return: void
     */
    void updateArticle(Article article);

    /**
     * @details: 删除文章
     * @date: 2023/5/27
     * @Param: [articleId]
     * @return: void
     */
    void deleteArticle(Integer articleId);

    /**
     * @details: 根据文章id查找文章
     * @date: 2023/5/27
     * @Param: [articleId]
     * @return: com.blog.personalblog.entity.Article
     */
    ArticleVO findById(Integer articleId);


    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

    /**
     * 新建文章
     * @param bo
     * @return
     */
    void insertOrUpdateArticle(ArticleInsertBO bo);


}


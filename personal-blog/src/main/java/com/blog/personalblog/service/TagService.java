package com.blog.personalblog.service;

import com.blog.personalblog.bo.TagBO;
import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.Tag;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-22 18:26:18
 * @description 标签服务接口
 */
public interface TagService {

    /**
     * @details: 获取所有的标签（分页）
     * @date: 2023/5/22
     * @Param: [pageRequest]
     * @return: java.util.List<com.blog.personalblog.entity.Tag>
     */
    List<Tag> getTagPage(PageRequest pageRequest);

    /**
     * @details: 新建标签
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: int
     */
    int saveTag(Tag tag);

    /**
     * @details: 修改标签
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: int
     */
    int updateTag(Tag tag);

    /**
     * @details: 删除标签
     * @date: 2023/5/22
     * @Param: [tagId]
     * @return: void
     */
    void deleteTag(Integer tagId);

    /**
     * @details: 批量添加
     * @date: 2023/5/22
     * @Param: [tags]
     * @return: boolean
     */
    boolean batchAddTag(String tags) throws Exception;

    /**
     * @details: 批量删除标签
     * @date: 2023/5/22
     * @Param: [ids]
     * @return: boolean
     */
    boolean batchDelTag(String ids);

    /**
     * @details: 根据标签查找
     * @date: 2023/5/22
     * @Param: [tagName]
     * @return: com.blog.personalblog.entity.Tag
     */
    Tag findByTagName(String tagName);


    Tag findTagById(Integer id);

    /**
     * 搜索文章标签
     *
     * @param bo
     * @return
     */
    List<Tag> getTagsByTagName(TagBO bo);
}
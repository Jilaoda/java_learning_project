package com.blog.personalblog.mapper;

import com.blog.personalblog.bo.TagBO;
import com.blog.personalblog.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-22 17:46:39
 * @description
 */
@Repository
public interface TagMapper {

    /**
     * @details: 创建
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: int
     */
    int createTag(Tag tag);

    /**
     * @details: 修改
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: int
     */
    int updateTag(Tag tag);

    /**
     * @details: 分类列表（分页）
     * @date: 2023/5/22
     * @Param: []
     * @return: java.util.List<com.blog.personalblog.entity.Tag>
     */
    List<Tag> getTagPage();

    /**
     * @details: 删除
     * @date: 2023/5/22
     * @Param: [id]
     * @return: void
     */
    void deleteTag(Integer id);

    /**
     * @details: 批量添加标签
     * @date: 2023/5/22
     * @Param: [strings]
     * @return: boolean
     */
    boolean batchAddTag(List<Tag> strings);

    /**
     * @details: 批量删除标签
     * @date: 2023/5/22
     * @Param: [ids]
     * @return: boolean
     */
    boolean deleteBatch(List<Tag> ids);

    /**
     * @details: 根据标签查找该对象
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: com.blog.personalblog.entity.Tag
     */
    Tag getByTagName(Tag tag);

    Tag findTagById(Integer id);

    /**
     * 查询文章标签
     * @param bo
     * @return
     */
    List<Tag> findTagsByTagName(TagBO bo);

}

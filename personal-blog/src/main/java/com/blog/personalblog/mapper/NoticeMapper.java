package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-22 13:41:59
 * @description 个人博客通知信息的Mapper接口
 */
@Repository
public interface NoticeMapper {

    /**
     * @details:  创建
     * @date: 2023/5/22
     * @Param: [notice]
     * @return: int
     */
    int createNotice(Notice notice);

    /**
     * @details: 修改
     * @date: 2023/5/22
     * @Param: [notice]
     * @return: int
     */
    int updateNotice(Notice notice);

    /**
     * @details: 分类列表（分页）
     * @date: 2023/5/22
     * @Param: []
     * @return: java.util.List<com.blog.personalblog.entity.Notice>
     */
    List<Notice> getNoticePage();

    /**
     * @details: 删除
     * @date: 2023/5/22
     * @Param: [id]
     * @return: void
     */
    void deleteNotice(Integer id);

    /**
     * 获取公告
     * @param id
     * @return
     */
    Notice getNoticeById(Integer id);


}
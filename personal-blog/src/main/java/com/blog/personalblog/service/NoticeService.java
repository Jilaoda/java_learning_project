package com.blog.personalblog.service;

import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.Notice;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-22 13:38:00
 * @description
 */
public interface NoticeService {

    /**
     * @details: 获取所有的分类（分页）
     * @date: 2023/5/22
     * @Param: [pageRequest]
     * @return: java.util.List<com.blog.personalblog.entity.Notice>
     */
    List<Notice> getNoticePage(PageRequest pageRequest);
    
    /**
     * @details: 新建通知
     * @date: 2023/5/22
     * @Param: [notice]
     * @return: int
     */ 
    int saveNotice(Notice notice);

    /**
     * @details: 修改分类
     * @date: 2023/5/22
     * @Param: [notice]
     * @return: int
     */
    int updateNotice(Notice notice);

    /**
     * @details: 删除分类
     * @date: 2023/5/22
     * @Param: [noticeId]
     * @return: void
     */
    void deleteNotice(Integer noticeId);

    /**
     * 根据公告id获取公告
     * @param noticeId
     * @return
     */
    Notice getNoticeById(Integer noticeId);

}

package com.blog.personalblog.service.impl;

import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.Notice;
import com.blog.personalblog.service.NoticeService;
import com.blog.personalblog.mapper.NoticeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-22 13:40:46
 * @description
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticePage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> noticeList = noticeMapper.getNoticePage();
        return noticeList;
    }

    @Override
    public int saveNotice(Notice notice) {
        return noticeMapper.createNotice(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public void deleteNotice(Integer noticeId) {
        noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public Notice getNoticeById(Integer noticeId) {
        Notice notice = noticeMapper.getNoticeById(noticeId);
        return notice;
    }

}
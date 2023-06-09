package com.yedam.notice.service;

import java.util.List;

import com.yedam.notice.domain.NoticeVO;

public interface NoticeService {
	
	//CRUD+목록조회+,,..기능들
	//create, read, update, delete
	
	public List<NoticeVO> noticeList(int page);
	public boolean addNotice(NoticeVO vo);
	public boolean modifyNotice(NoticeVO vo);
	public boolean removeNotice(int noticeId);
	public NoticeVO getNotice(int noticeId);
	
	public int totalCount();
	
}

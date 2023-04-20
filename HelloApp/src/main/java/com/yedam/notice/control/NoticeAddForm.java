package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class NoticeAddForm implements Control {

	
	//공지사항 등록 화면보여주기
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		
		//return "WEB-INF/views/notice/noticeAddForm.jsp";
		return "notice/noticeAddForm.tiles";
	}

}

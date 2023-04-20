package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class modifyNoticeForm implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		// TODO Auto-generated method stub
		return "notice/noticeModify.tiles";
	}

}

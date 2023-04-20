package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class modifyNoticeControl implements Control {

	
	//공지사항목록>번호클릭> 상세페이지 수정클릭> 수정페이지
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		NoticeService service= new NoticeServiceImpl();
		
		//get방식일때 : 수정화면 보여주기
		if(req.getMethod().equals("GET")) {
			String nid= req.getParameter("nid");
			NoticeVO vo= service.getNotice(Integer.parseInt(nid));
			req.setAttribute("noticeInfo", vo);
								
			return "notice/noticeModify.tiles";
			
		//post방식 일때
		}else if(req.getMethod().equals("POST")){
			String nid= req.getParameter("nid");
			String title= req.getParameter("title");
			String subject = req.getParameter("subject");
			
			NoticeVO vo= new NoticeVO();
			vo.setNoticeId(Integer.parseInt(nid));
			vo.setNoticeTitle(title);
			vo.setNoticeSubject(subject);
			service.modifyNotice(vo);
			
		}

		return "noticeList.do";

	
	}

}

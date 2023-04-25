package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class AddNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		// 파일업로드, db입력처리, 목록이동.
		
		//1.파일업로드.
		//멀티파트 요청: MultipartRequest()
		//매개변수: 요청정보, 저장경로, 업로드 최대파일 사이즈, 인코딩, 리네임정책 인스턴스를 매개값으로  
		String saveDir = req.getServletContext().getRealPath("images");
		int maxSize= 5*1024*1024; //5메가
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy();
		
		MultipartRequest multi 
		= new MultipartRequest(req,saveDir,maxSize,encoding,rn);
		
		String writer = multi.getParameter("writer");
		String subject= multi.getParameter("subject");
		String title= multi.getParameter("title");
		String attach = multi.getFilesystemName("attach");
		
		//사용자의 입력값을 NoticeVO에 담아서 입력하기.
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(writer);
		vo.setNoticeTitle(title);
		vo.setNoticeSubject(subject);
		vo.setAttachFile(attach);

		NoticeService service = new NoticeServiceImpl();
		
		//정상처리되면 -> 목록으로 이동
		//else => main 페이지로 이동
		if(service.addNotice(vo)) {
			return "notice/noticeList.tiles";
		}else {
			return "main.do";
			
		}

	}

}

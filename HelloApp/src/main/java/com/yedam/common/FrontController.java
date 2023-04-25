package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.notice.control.AddNoticeControl;
import com.yedam.notice.control.AddReplyControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeListControl;
import com.yedam.notice.control.RemoveReplyControl;
import com.yedam.notice.control.ReplyListControl;
import com.yedam.notice.control.GetNoticeControl;
import com.yedam.notice.control.ModifyReplyControl;
import com.yedam.notice.control.modifyNoticeControl;
import com.yedam.notice.control.modifyNoticeForm;

//공지사항 컨트롤러
public class FrontController extends HttpServlet {

	private Map<String, Control> map;
	String encoding;

	public FrontController() {
		map = new HashMap<>(); // ?

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		
		//첫페이지
		map.put("/main.do", new MainControl());	
		
		//공지사항 목록
		map.put("/noticeList.do", new NoticeListControl());
		
		//공지사항 등록-화면열어주는
		map.put("/noticeAddForm.do", new NoticeAddForm());
		
		//공지사항 컨트롤
		map.put("/addNotice.do", new AddNoticeControl());		
		
		//번호 클릭시 조회
		map.put("/getNotice.do", new GetNoticeControl());
		
		//수정페이지-열어주는 화면
		map.put("/modifyNoticeForm.do", new modifyNoticeForm());
		
		//수정 컨트롤
		map.put("/modifyNotice.do", new modifyNoticeControl());
		
		//로그인 화면
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do",new LoginControl());
		
		//로그아웃 화면
		map.put("/logout.do", new LogoutControl());
		
		//댓글정보
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		
		//댓글삭제
		map.put("/removeReply.do",new RemoveReplyControl());
		//댓글수정
		map.put("/modifyReply.do",new ModifyReplyControl());
		
		//차트생성
		map.put("/chart.do", new ChartFormControl());
		
		map.put("/chartData.do", new ChartDataControl());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//인코딩 방식 
		
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println("path: "+path);
		
		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println("viewPage: "+viewPage);
		
		if(viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return; //메소드 종료
		}
		
		if(viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
													//처음부터 시작해서 .json 빼고
			return; //메소드종료
		}
		
		//페이지 재지정.
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
				
	}

	
	
	
	
	
	
	
}




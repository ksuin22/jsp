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
import com.yedam.member.control.modifyMemberControl;
import com.yedam.member.control.modifyMemberFormControl;
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
		
		//공지사항 등록-폼
		map.put("/noticeAddForm.do", new NoticeAddForm());
		//공지사항 등록-컨트롤
		map.put("/addNotice.do", new AddNoticeControl());		
		
		//공지사항 번호 클릭시 상세조회
		map.put("/getNotice.do", new GetNoticeControl());
		
		//공지사항 수정-폼
		map.put("/modifyNoticeForm.do", new modifyNoticeForm());
		//공지사항 수정-컨트롤
		map.put("/modifyNotice.do", new modifyNoticeControl());
		
		//로그인화면 -폼
		map.put("/loginForm.do", new LoginFormControl());
		//로그인화면 -컨트롤
		map.put("/login.do",new LoginControl());
		
		//로그아웃 화면-컨트롤
		map.put("/logout.do", new LogoutControl());
		
		//회원정보수정-폼, 컨트롤
		map.put("/modifyMemberForm.do",new modifyMemberFormControl());
		map.put("/modifyMember.do",new modifyMemberControl());
		
		//댓글정보
		map.put("/replyList.do", new ReplyListControl());
		//댓글추가
		map.put("/addReply.do", new AddReplyControl());
		//댓글삭제
		map.put("/removeReply.do",new RemoveReplyControl());
		//댓글수정
		map.put("/modifyReply.do",new ModifyReplyControl());
		
		//차트화면
		map.put("/chart.do", new ChartFormControl());
		map.put("/chartData.do", new ChartDataControl());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//인코딩 방식 
		
		//어떤 요청을 했는지 구분해준다. uri부분만 가져오기 어떤.do인지
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println("path: "+path);
		
		//그 컨트롤을 실행시킨다.
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
		
		//.tiles가 디폴트. 페이지열어줌
		//페이지 재지정.
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
				
	}

	
	
	
	
	
	
	
}




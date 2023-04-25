package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.domain.MemberVO;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;

public class modifyMemberControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String phone =req.getParameter("phone");
		String adr = req.getParameter("adr");
		
		MemberVO vo = new MemberVO();
		vo.setEmail(id);
		vo.setPassword(pw);
		vo.setPhone(phone);
		vo.setAddress(adr);
		
		MemberService service = new MemberServiceImpl();
		boolean result = service.modifyMember(vo);
		
		if(result) {
			return "noticeList.do";
		}else {
			
			return "modifyMemberForm.do";
		}
		
	}

}

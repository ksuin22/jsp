package com.yedam.member.service;

import java.util.Map;

import com.yedam.member.domain.MemberVO;

public interface MemberService {
	

	
	public MemberVO loginCheck(MemberVO vo);
	public boolean modifyMember(MemberVO vo);
		//확인용이면 boolean
	    
	public Map<String, Object> memberByDept();
	

	

}

package com.yedam.member.mapper;

import java.util.List;

import com.yedam.member.domain.MemberVO;


public interface MemberMapper {
	
	
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO updateMember(MemberVO vo);
	

}

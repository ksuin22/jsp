package com.yedam.member.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.member.domain.MemberVO;


public interface MemberMapper {
	
	
	public MemberVO loginCheck(MemberVO vo);
	public int updateMember(MemberVO vo);
	  //행이 업데이트 되었다.
	
	public List<Map<String, Object>> memberByDept();

}

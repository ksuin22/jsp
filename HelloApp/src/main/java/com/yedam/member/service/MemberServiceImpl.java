package com.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.domain.MemberVO;
import com.yedam.member.mapper.MemberMapper;

public class MemberServiceImpl implements MemberService{
	
	SqlSession session = DataSource.getInstance().openSession(true); // true가 들어가면 자동커밋
	MemberMapper mapper = session.getMapper(MemberMapper.class);

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return mapper.loginCheck(vo);

	}
	
	

}

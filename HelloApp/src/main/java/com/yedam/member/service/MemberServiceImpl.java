package com.yedam.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	
	@Override
	public Map<String, Object> memberByDept() {
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> list = mapper.memberByDept();
		for (Map<String, Object> map : list) {
			Set<String> set = map.keySet(); //키값만 set에 담아주는거: keySet
				System.out.println(map.get("DEPARTMENT_NAME") + ":"+ map.get("CNT"));
				result.put((String)map.get("DEPARTMENT_NAME"), map.get("CNT"));
				
			}
						
		
		return result;
	}
	

}

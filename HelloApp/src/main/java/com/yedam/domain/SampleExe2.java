package com.yedam.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.member.mapper.MemberMapper;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe2 {
	public static void main(String[] args) {

		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();

		// mybatis 사이트- 시작하기 - SqlSessionFactory 에서 SqlSession 만들기 -코드복사
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);

//				Employee empl = new Employee();
//				empl.setEmployeeId(310);
//				empl.setLastName("Kim");
//				empl.setEmail("sese333");
//				empl.setJobId("IT_PROG");
//				mapper.addEmp(empl);
//				session.commit();
//				
//			  Employee emp = mapper.getEmp(310);
//			  System.out.println(emp);
//
//			  NoticeVO nvo = new NoticeVO();
//			  NoticeVO nvo2 = new NoticeVO();
//			  
//			  //추가
//			  nvo.setNoticeWriter("kim2");
//			  nvo.setNoticeTitle("안녕하세요2");
//			  nvo.setNoticeSubject("내용!2");
//			  mapper.insertNotice(nvo); //
//			  
//			  //삭제
//			  mapper.deleteNotice(6);
//			  
//			  //조회
//			  System.out.println(mapper.searchNotice(5));		   
//			  

//			  //수정
//			  nvo2.setNoticeId(5);
//			  nvo2.setNoticeTitle("박수정");
//			  nvo2.setNoticeSubject("내용!2");
//			  mapper.updateNotice(nvo2);
//			 
//			  //전체목록
//			  for(NoticeVO vo : mapper.noticeList()) {
//				  System.out.println(vo);  
//			  }
//	
			List<Map<String, Object>> list = mapper.memberByDept();
			// [{부서명,부서인원수},{부서명,부서인원수},{},...,{}]
			for (Map<String, Object> map : list) {
				Set<String> set = map.keySet(); //키값만 set에 담아주는거: keySet
				for (String key : set) {
					System.out.println(map.get("DEPARTMENT_NAME") + ":"+ map.get("CNT"));
					
				}
				
				
			}

		}

	}
}

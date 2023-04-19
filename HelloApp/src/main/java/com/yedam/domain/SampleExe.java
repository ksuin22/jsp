package com.yedam.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SampleExe {
	public static void main(String[] args) {
		
		
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			
			//Employee emp = session.selectOne("com.yedam.commom.NoticeMapper.getEmp", 100);
			
			//session.delete("com.yedam.commom.NoticeMapper.delEmp",223);
						
			Employee empl = new Employee();
			empl.setEmployeeId(500);
			empl.setLastName("Kim");
			empl.setEmail("sese333");
			empl.setJobId("IT_PROG");
			session.insert("com.yedam.common.NoticeMapper.addEmp",empl);
					
			List<Employee> emp =session.selectList("com.yedam.common.NoticeMapper.emplist");
			
			System.out.println(emp);
			  
			}		
		
	}

}

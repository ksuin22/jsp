package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.domain.Employee;
import com.yedam.notice.domain.NoticeVO;

public interface NoticeMapper {
	
	public Employee getEmp(int empId);
	public List<Employee> empList();
	public int delEmp(int empId);
	public int addEmp(Employee emp);
	
	
	//공지사항. CRUD: 입력,조회,수정,삭제, 목록
	
	public List<NoticeVO> noticeList(); //목록
	public List<NoticeVO> noticeWithPage(int page); //페이징 리스트
	public int insertNotice(NoticeVO vo);//입력
	public int updateNotice(NoticeVO vo);//수정
	public int deleteNotice(int NoticeId);//삭제
	public NoticeVO searchNotice(int noticeId); //조회
	
	//조회수 증가
	public int updateCount(int noticeId);
	
	public int getCount();
	
	

}

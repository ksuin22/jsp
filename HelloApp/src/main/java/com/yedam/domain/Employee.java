package com.yedam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //전체 필드를 가지는 생성자를 만들어줌 
@NoArgsConstructor //기본생성자 만들어줌


public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String jobId;
	
	

}

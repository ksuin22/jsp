package com.yedam.common;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PageDTO {

	//공지사항 목록 내 페이지
	private int startPage; //한화면의 시작페이지
	private int endPage;  //마지막페이지
	private boolean prev; //이전페이지
	private boolean next; //다음페이지
	private int pageNum; //현재페이지
	
	
	public PageDTO(int pageNum, int total) {
		this.pageNum= pageNum;
		
								//올림
		this.endPage= (int) Math.ceil(this.pageNum/10.0) * 10; 
		this.startPage= this.endPage -9; 
		
		int realEnd = (int) (Math.ceil(total /10.0));// 최종페이지
		
		if(realEnd < this.endPage) {
			this.endPage =realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		
		
	}
	
}

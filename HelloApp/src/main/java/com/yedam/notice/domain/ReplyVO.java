package com.yedam.notice.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	//db 칼럼대로 필드선언
	private int replyId;
	private int noticeId;
	private String reply;
	private String replyWriter;
	private Date replyDate;
	

}

package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	// 어떤 글에 대한 댓글인가
	public List<ReplyVO> replyList(int noticeId);
	
	//댓글등록
	public int insertReply(ReplyVO vo);
	
	//댓글삭제
	public int removeReply (int replyId);
	
	//댓글수정
	public int updateReply(ReplyVO vo);
	

}

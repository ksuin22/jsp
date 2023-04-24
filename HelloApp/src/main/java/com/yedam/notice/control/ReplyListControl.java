package com.yedam.notice.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class ReplyListControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		String nid = req.getParameter("nid");
		
		//데이터를 넘겨줘야함.
		//json 데이터 생성.
		//양식: [{"replyId":5, "noticeId":98, "reply":"98번댓글",..,
		// 					"replyDate":"}]
		ReplyService service = new ReplyServiceImpl();
		
		String json ="[";
		List<ReplyVO>list = service.getReplies(Integer.parseInt(nid));
		for(int i=0; i<list.size(); i++) {
			//위 양식대로 만들기
			json += "{\"replyId\":"+list.get(i).getReplyId()+",";
			json += "\"noticeId\":"+list.get(i).getNoticeId()+",";
			json += "\"reply\":\""+list.get(i).getReply()+"\",";
			json += "\"replyWriter\":\""+list.get(i).getReplyWriter()+"\",";
			json += "\"replyDate\":\""+list.get(i).getReplyDate()+"\"}";
			
			if(i+1 !=list.size()) {
				json += ",";
									
			}
		}
		
		json+= "]";
		return json +".json";
	}

}

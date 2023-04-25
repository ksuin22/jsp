package com.yedam.notice.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class ModifyReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		
		// 파라미터(댓글번호, 변경된 댓글내용)
		
		//update.
		ReplyVO vo = new ReplyVO();
		vo.setReply(req.getParameter("reply"));
		vo.setReplyId(Integer.parseInt(req.getParameter("rid")));
		
		ReplyService service = new ReplyServiceImpl();
		service.addReply(vo);
		
		
		boolean result = false;	
		vo = new ReplyVO();
		String json = "";
		
		Map<String, Object> map = new HashMap<>();
		
		if(result) {
			//search.
			map.put("retCode", "Success");
			map.put("data",vo);
		}else {			
			map.put("retCode", "Fail");
		}
		Gson gson = new GsonBuilder().create(); //gson 객체 만들어줌
		json= gson.toJson(map);
		
		return json + ".json"; //
		
	}
		

}

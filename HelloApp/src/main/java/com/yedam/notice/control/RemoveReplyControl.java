package com.yedam.notice.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		String id = req.getParameter("rid");
		
		ReplyService service = new ReplyServiceImpl();
		boolean result = service.removeReply(Integer.parseInt(id));
		
		String json = "";
		Map<String, Object> map = new HashMap<>();
		
		if(result) {			
			json = "{\"retCode \": \"Success\"}";	
		}else {
			//{"retCod":"Fail"}			
			json = "{\"retCode\":\"Fail\"}";			
		}
		return json + ".json";
		
	}

}


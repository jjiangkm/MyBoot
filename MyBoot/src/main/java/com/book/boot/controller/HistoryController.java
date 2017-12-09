package com.book.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.boot.model.HistoryDto;
import com.book.boot.model.ResponseData;
import com.book.boot.service.HistoryService;

@Controller
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllHistory")
	@ResponseBody
	public ResponseData<List<HistoryDto>> getAllHistory(HttpServletRequest request){
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		Map<String, String> map = new HashMap<>();
		map.put("month", month);
		map.put("day", day);
		return historyService.getAllHistory(map);
	}
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getHistoryById")
	@ResponseBody
	public ResponseData<List<HistoryDto>> getHistoryById(HttpServletRequest request){
		String id = request.getParameter("id");
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return historyService.getHistoryById(map);
	}
	
}

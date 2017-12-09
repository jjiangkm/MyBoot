package com.book.boot.mapping;

import java.util.List;
import java.util.Map;

import com.book.boot.model.HistoryDto;

public interface HistoryMapper {

/*	
	boolean delete(int id);
	User findById(int id);*/
	boolean updateHistory(HistoryDto dto);
	void saveHistorys(List<HistoryDto> allHistory);
	List<HistoryDto> getAllHistory(Map<String, String> map);
	List<HistoryDto> getHistoryById(Map<String, String> map);
}

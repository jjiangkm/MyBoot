package com.book.boot.service;


import java.util.List;
import java.util.Map;

import com.book.boot.model.HistoryDto;
import com.book.boot.model.ResponseData;

public interface HistoryService {
	ResponseData<List<HistoryDto>> getAllHistory(Map<String, String> map);
	ResponseData<List<HistoryDto>> getHistoryById(Map<String, String> map);
}

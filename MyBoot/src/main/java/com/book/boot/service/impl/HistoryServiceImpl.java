package com.book.boot.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.tomcat.dbcp.dbcp2.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.book.boot.mapping.HistoryMapper;
import com.book.boot.model.HistoryDto;
import com.book.boot.model.ResponseData;
import com.book.boot.service.HistoryService;
import com.book.boot.utils.RestClientUtil;

@Service
@Transactional 
public class HistoryServiceImpl implements HistoryService {
	@Resource
	private HistoryMapper historyMapper;
	@Override
	public ResponseData<List<HistoryDto>> getAllHistory(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<HistoryDto> allHistory = historyMapper.getAllHistory(map);
		ResponseData<List<HistoryDto>> rd  = null;
		List<HistoryDto> allHistoryFromInternet = null;
		if(allHistory!=null&&allHistory.size()>0){//数据库中有数�?
			
			HistoryDto newHistoryDto = allHistory.get(0);//因为我们是按时间降序，第�?个是�?近时间获取的
			int year = newHistoryDto.getCreatedDate().getYear()+1900;
			if(year!=Calendar.getInstance().get(Calendar.YEAR)){//每年只需更新�?次，如果年不同就要去网上重新请求数据
				rd  = RestClientUtil.getHistoryToday(map);
				if(allHistory.size()!=rd.getResult().size()){//如果获取到的数据和之前的数量不相同则�?要获取到多余的数�?
					allHistoryFromInternet = new ArrayList<>();
					for(HistoryDto dto :rd.getResult()){
						//判断dto是否在数据库中有，如果没有就要去增加
						boolean isNewData = true;
						for(HistoryDto dto1:allHistory){
							if(dto.get_id().equals(dto1.get_id())){
								isNewData = false;
								break;
							}
						}
						if(isNewData){
							allHistoryFromInternet.add(dto);
						}
					}
				}
			}else{
				rd = new ResponseData<>("0","",allHistory);
			}
		}else{//数据库中没有数据
			rd  = RestClientUtil.getHistoryToday(map);
			allHistoryFromInternet = rd.getResult();
		}
		if(allHistoryFromInternet!=null&&allHistoryFromInternet.size()>0){
			historyMapper.saveHistorys(allHistoryFromInternet);
		}
		return rd;
	}
	@Override
	public ResponseData<List<HistoryDto>> getHistoryById(Map<String, String> map) {
		// TODO Auto-generated method stub
		ResponseData<List<HistoryDto>> rd  = null;
		List<HistoryDto> allHistory = historyMapper.getHistoryById(map);
		if(allHistory!=null&&allHistory.size()>0){
			HistoryDto historyDto = allHistory.get(0);
			if(StringUtils.isEmpty(historyDto.getContent())){
				rd  = RestClientUtil.getHistoryTodayById(map);
				List<HistoryDto> result = rd.getResult();
				if(result!=null&&result.size()>0){
					historyMapper.updateHistory(result.get(0));
				}
			}else{
				rd = new ResponseData<>("0","",allHistory);
			}
			
		}else{
			rd = new ResponseData<>("1002","不合法的id",allHistory);
		}
		return rd;
	}
	

}

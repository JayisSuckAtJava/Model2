package com.spring.service;

import java.util.List;

import com.spring.model2.dto.BoardDto;

public interface BoardService {
	
	BoardDto select(String bid);
	int insert(BoardDto dto);
	int update(BoardDto dto);
	int delete(String bid);
	int getWrite(BoardDto dto);
	int getTotalCount();
	List<BoardDto> getList(int startCount, int endCount);

}

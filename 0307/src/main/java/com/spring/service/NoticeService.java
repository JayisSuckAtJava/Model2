package com.spring.service;

import java.util.List;

import com.spring.model2.dto.BoardDto;

public interface NoticeService {

	List<BoardDto> getList(int startCount, int endCount);

	BoardDto content(String bid);

	BoardDto select(String bid);

	int update(BoardDto dto);

	int insert(BoardDto dto);

	int delete(String bid);

	int getTotalCount();

}

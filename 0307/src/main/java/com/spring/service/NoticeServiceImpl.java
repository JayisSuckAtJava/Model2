package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BoardDao;
import com.spring.model2.dto.BoardDto;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardDto content(String bid) {
		boardDao.updateHit(bid);
		return boardDao.select(bid);
	}


	@Override
	public List<BoardDto> getList(int startCount, int endCount) {
		return boardDao.getList(startCount,endCount);
	}


	@Override
	public BoardDto select(String bid) {
		return boardDao.select(bid);
	}


	@Override
	public int update(BoardDto dto) {
		return boardDao.update(dto);
	}


	@Override
	public int insert(BoardDto dto) {
		return boardDao.noticeWrite(dto);
	}


	@Override
	public int delete(String bid) {
		return boardDao.delete(bid);
	}


	@Override
	public int getTotalCount() {
		return boardDao.selectNCount();
	}
	
	
}

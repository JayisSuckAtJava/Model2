package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BoardDao;
import com.spring.model2.dto.BoardDto;
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardDto select(String bid) {
		boardDao.updateHit(bid);
		return boardDao.select(bid);
	}

	@Override
	public int delete(String bid) {
		return boardDao.delete(bid);
	}

	@Override
	public int update(BoardDto dto) {
		return boardDao.update(dto);
	}

	@Override
	public int insert(BoardDto dto) {
		return boardDao.insert(dto);
	}

	@Override
	public int getWrite(BoardDto dto) {
		return boardDao.getWrite(dto);
	}

	@Override
	public int getTotalCount() {
		return boardDao.selectCount();
	}

	@Override
	public List<BoardDto> getList(int startCount, int endCount) {
		return boardDao.select(startCount, endCount);
	}

}
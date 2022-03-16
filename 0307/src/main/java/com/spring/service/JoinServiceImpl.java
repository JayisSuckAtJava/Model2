package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDao;
import com.spring.model2.dto.MemberDto;
@Service("joinService")
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public int insert(MemberDto dto) {
		return memberDao.insert(dto);
	}

}

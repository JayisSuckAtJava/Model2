package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDao;
import com.spring.model2.dto.MemberDto;

@Service("loginService")
public class LoginServiceImpl implements LoginService {


	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int select(MemberDto dto) {
		int result = memberDao.select(dto);
		return result;
	}
}

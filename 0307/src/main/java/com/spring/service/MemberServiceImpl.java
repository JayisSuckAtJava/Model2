package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDao;
import com.spring.model2.dto.MemberDto;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
		
	@Override
	public List<MemberDto> getList(int startCount, int endCount){
		return memberDao.select(startCount, endCount);
	}
	

	@Override
	public MemberDto select(String id) {
		return memberDao.select(id);
	}


	@Override
	public int getTotalCount() {
		return memberDao.getTotalCount();
	}
}
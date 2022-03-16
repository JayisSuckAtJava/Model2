package com.spring.service;

import java.util.List;

import com.spring.model2.dto.MemberDto;

public interface MemberService {
	
	List<MemberDto> getList(int startCount, int endCount); 
	MemberDto select(String id);
	int getTotalCount();
}
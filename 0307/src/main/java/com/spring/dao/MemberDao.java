package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model2.dto.MemberDto;
@Repository
public class MemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.member";
	
	/**
	 * R(Select) : 회원리스트 select 
	 * @param endCount 
	 * @param startCount 
	 */
	public List<MemberDto> select(int startCount, int endCount){
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		map.put("start", startCount);
		map.put("end", endCount);
		
		list = sqlSession.selectList(namespace + ".listAll", map);
		
		return list;
		
	}

	public int select(MemberDto dto) {
		System.out.println(dto.getId()+" 님이 접속 하셨습니다.");
		return sqlSession.selectOne(namespace+".login",dto);
	}

	public int insert(MemberDto dto) {
		System.out.println(dto.getId()+" 님이 가입 하셨습니다.");
		return sqlSession.insert(namespace+".sginin", dto);
	}
	
	public MemberDto select(String id) {
		return sqlSession.selectOne(namespace+".detail", id);
	}

	public int getTotalCount() {
		return sqlSession.selectOne(namespace + ".count");
	}


		
	/*	
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = " select rownum rno,id, name, email, hp_num, hobby "
				+ " from (select id, name, email, hp_num, hobby "
				+ "        from member  order by id) ";
		
		try {
			pstmt = getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setRno(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setHp_num(rs.getString(5));
				dto.setHobby(rs.getString(6));
				
				list.add(dto);
			}
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return list;
		*/
}
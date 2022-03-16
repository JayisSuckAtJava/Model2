package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model2.dto.BoardDto;
@Repository
public class BoardDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.board";
	
	/** 
	 * R : �Խñ� �󼼺��� select
	 */
	public BoardDto select(String bid){
		BoardDto dto = sqlSession.selectOne(namespace+".content", bid);
		
		/*BoardDto dto = new BoardDto();
		String sql = " select bid, btitle, bcontent, bhit,to_char(bdate,'yyyy/mm/dd') bdate "
				+ " from board where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {					
				dto.setBid(rs.getString(1));
				dto.setBtitle(rs.getString(2));
				dto.setBcontent(rs.getString(3));
				dto.setBhit(rs.getInt(4));
				dto.setBdate(rs.getString(5));		
			}
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/		
		
		return dto;
	}
	
	/** 
	 * R : �Խñ� ��ü select
	 */
	public List<BoardDto> select(int startCount, int endCount){
		// Mapper�� �ѱ涧 �Ķ���͸� �������� ���� �ѱ�� ���⿡, Map �� 2�� �� �־ �ѱ�
		//	Ȥ�� dto�� �Ѱܾ� ������ pageing �� ���� ������ ����̱⿡ �׳� ������ �ѱ�
		List<BoardDto> list = new ArrayList<BoardDto>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("start", startCount);
		map.put("end", endCount);
		
		list = sqlSession.selectList(namespace + ".listAll", map);

		return list;
	}
	
	
	/** 
	 * C : �Խñ� update
	 */
	public int update(BoardDto dto) {
		return sqlSession.update(namespace+".update", dto);
		/*
		int result = 0;
		String sql = "update board set btitle=?, bcontent=? where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBid());
			
			result = pstmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;*/
	}
	
	/** 
	 * C : �Խñ� ��ȸ�� update
	 */
	public void updateHit(String bid) {
		sqlSession.update(namespace+".hit",bid);
		/*
		String sql = "update board set bhit = bhit+1 where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);					
			pstmt.executeUpdate();
			
		//	 close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	
	/** 
	 * C : �Խñ� delete
	 */
	public int delete(String bid) {
		return sqlSession.delete(namespace+".delete", bid);
		/*
		int result = 0;
		String sql = "delete from board where bid=?";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, bid);
					
			result = pstmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	/** 
	 * C : �Խñ� insert
	 */
	public int insert(BoardDto dto) {
		return sqlSession.insert(namespace+".write", dto);
	}
		/*int result = 0;
		String sql = "INSERT INTO BOARD VALUES('b_'||SEQU_BOARD_BID.nextval,?,?,0,sysdate)";
		
		try {
			pstmt = getPreparedStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			
			result = pstmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}*/

	public List<BoardDto> getList(int startCount, int endCount) {
		List<BoardDto> list = new ArrayList<BoardDto>();
			
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", startCount);
		map.put("end", endCount);
		
		list = sqlSession.selectList(namespace + ".noticeListAll", map);
		
		return list;
	}

	public int getWrite(BoardDto dto) {
		return sqlSession.insert(namespace+".getWrite", dto);
	}
	
	public int noticeWrite(BoardDto dto) {
		return sqlSession.insert(namespace+".noticeWrite", dto);
	}
	
	public int selectCount(){
		return sqlSession.selectOne(namespace + ".count");	
	}
	public int selectNCount(){
		return sqlSession.selectOne(namespace + ".ncount");	
	}
	

	}



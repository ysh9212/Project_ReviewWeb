package com.project.board;

import java.sql.Connection;
import java.util.List;

import com.project.page.SearchRow;

public interface BoardDAO {
	
	public int getNum() throws Exception;
	
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception;
	
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception;
	
	public BoardDTO selectOne(int no, Connection con) throws Exception;
	
	public int insert(Connection con) throws Exception;
	
	public int update(Connection con) throws Exception;
	
	public int delete(int no, Connection con) throws Exception;
	
	

}

package com.project.board;

import java.sql.Connection;
import java.util.List;

import com.project.shopPage.SearchRow;


public interface BoardDAO {
	//getNum
		public int getNum()throws Exception;
		
		//getTotalCount
		public int getTotalCount(SearchRow searchRow, Connection con) throws Exception;
		
		//selectList
		public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception;
		
		//select
		public BoardDTO selectOne(int num, Connection con) throws Exception;
		
		//insert
		public int insert(BoardDTO boardDTO, Connection con) throws Exception;
		
		//update
		public int update(BoardDTO boardDTO, Connection con) throws Exception;
		
		//delete
		public int delete(int num, Connection con) throws Exception;
}

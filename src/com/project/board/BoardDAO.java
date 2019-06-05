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
		public BoardDTO selectOne(int no, Connection con) throws Exception;
		
		//insert
		public int insert(BoardDTO boardDTO, Connection con) throws Exception;
		
		//update
		public int update(BoardDTO boardDTO, Connection con) throws Exception;
		
		//議고쉶�닔 �뾽
		public int updateHit(int no, Connection con) throws Exception;
		
		//delete
		public int delete(int no, Connection con) throws Exception;
}

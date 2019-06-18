package com.project.community.used;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchRow;

public class UsedDAO implements BoardDAO{

	@Override
	public int getNum() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHit(int no, Connection con) throws Exception {
		String sql = "update community_used set hit = hit+'1' where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return 0;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

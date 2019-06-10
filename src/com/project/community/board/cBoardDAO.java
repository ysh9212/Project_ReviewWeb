package com.project.community.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.action.ActionForward;
import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class cBoardDAO implements BoardDAO{

	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		return 0;
	}

	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select no from community_board order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}

	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		String sql = "select * from community_notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			boardDTO.setNo(rs.getInt("no"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setReg_date(rs.getString("reg_date"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setRecommend(rs.getInt("recommend"));
			boardDTO.setDecommend(rs.getInt("decommend"));
			boardDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHit(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

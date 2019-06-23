package com.project.membermy.Write;

import java.sql.*;
import java.util.*;

import com.project.board.*;
import com.project.community.board.*;
import com.project.shopPage.*;
import com.project.util.*;

public class MyWriteDAO implements BoardDAO{

	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select community_board_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		int result = 0;
		String sql ="select count(no) from community_board where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		return result;
	}
	
	public List<BoardDTO> List(Connection con)throws Exception{
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select title from community_board where rownum <= 5 order by no desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ComBoardDTO comBoardDTO = new ComBoardDTO();
			comBoardDTO.setTitle(rs.getString("title"));
			ar.add(comBoardDTO);
		}
		return ar;
	}

	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from " + 
				"(select rownum R, p.* from " + 
				"(select * from community_board where "+searchRow.getSearch().getKind()+" like ? order by no desc) p) " + 
				"where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ComBoardDTO comBoardDTO = new ComBoardDTO();
			comBoardDTO.setNo(rs.getInt("no"));
			comBoardDTO.setTitle(rs.getString("title"));
			comBoardDTO.setWriter(rs.getString("writer"));
			comBoardDTO.setReg_date(rs.getString("reg_date"));
			comBoardDTO.setHit(rs.getInt("hit"));
			comBoardDTO.setRecommend(rs.getInt("recommend"));
			comBoardDTO.setDecommend(rs.getInt("decommend"));
			ar.add(comBoardDTO);
		}
		rs.close();
		st.close();
		return ar;
	}

	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		ComBoardDTO comBoardDTO = new ComBoardDTO();
		String sql = "select * from commnity_board where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			comBoardDTO.setNo(rs.getInt("no"));
			comBoardDTO.setTitle(rs.getString("title"));
			comBoardDTO.setWriter(rs.getString("writer"));
			comBoardDTO.setContents(rs.getString("contents"));
			comBoardDTO.setReg_date(rs.getString("reg_date"));
			comBoardDTO.setHit(rs.getInt("hit"));
			comBoardDTO.setRecommend(rs.getInt("recommend"));
			comBoardDTO.setDecommend(rs.getInt("decommend"));
		}
		rs.close();
		st.close();
		return comBoardDTO;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

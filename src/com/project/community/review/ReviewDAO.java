package com.project.community.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ReviewDAO implements BoardDAO{

	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select community_seq.nextval from dual";
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
		String sql ="select count(no) from community_review where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		return result;
	}

	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select no, title, writer, reg_date, hit, recommend, decommend from community_review";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ReviewDTO reviewDTO = new ReviewDTO();
			reviewDTO.setNo(rs.getInt("no"));
			reviewDTO.setTitle(rs.getString("title"));
			reviewDTO.setWriter(rs.getString("writer"));
			reviewDTO.setReg_date(rs.getString("reg_date"));
			reviewDTO.setHit(rs.getInt("hit"));
			reviewDTO.setRecommend(rs.getInt("recommend"));
			reviewDTO.setDecommend(rs.getInt("decommend"));
			ar.add(reviewDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		ReviewDTO reviewDTO = new ReviewDTO();
		String sql = "select * from community_review where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			reviewDTO.setNo(rs.getInt("no"));
			reviewDTO.setTitle(rs.getString("title"));
			reviewDTO.setWriter(rs.getString("writer"));
			reviewDTO.setReg_date(rs.getString("reg_date"));
			reviewDTO.setHit(rs.getInt("hit"));
			reviewDTO.setRecommend(rs.getInt("recommend"));
			reviewDTO.setDecommend(rs.getInt("decommend"));
			reviewDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return reviewDTO;
	}
	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into community_review values(community_seq.nextval,?,?,sysdate,0,0,0,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		result = st.executeUpdate();
		st.close();
		return result;
	}
	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "update community_review set title=?, contents=? where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNo());
		result = st.executeUpdate();
		st.close();
		return result;
	}

	@Override
	public int updateHit(int no, Connection con) throws Exception {
		String sql = "update community_review set hit = hit+'1' where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return 0;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		String sql = "delete community_review where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return result;
	}
}

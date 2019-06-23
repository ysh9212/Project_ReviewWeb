package com.project.community.board.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.project.community.comments.CommunityCommentsDAO;
import com.project.community.comments.CommunityCommentsDTO;
import com.project.shopPage.SearchRow;

public class ComBoardCommentsDAO implements CommunityCommentsDAO{
	@Override
	public List<CommunityCommentsDTO> selectList(SearchRow searchRow, int no, Connection con) throws Exception {
		List<CommunityCommentsDTO> ar = new ArrayList<CommunityCommentsDTO>();
		String sql ="select * from "
				+ "(select rownum R, C.* from "
				+ "(select * from community_board_comments where no=? order by cnum desc) C) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ComBoardCommentsDTO comBoardCommentsDTO = new ComBoardCommentsDTO();
			comBoardCommentsDTO.setCnum(rs.getInt("cnum"));
			comBoardCommentsDTO.setNo(rs.getInt("no"));
			comBoardCommentsDTO.setWriter(rs.getString("writer"));
			comBoardCommentsDTO.setContents(rs.getString("contents"));
			comBoardCommentsDTO.setReg_date(rs.getString("reg_date"));
			ar.add(comBoardCommentsDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	@Override
	public int insert(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into community_board_comments values(community_board_comments_seq.nextval,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, communityCommentsDTO.getNo());
		st.setString(2, communityCommentsDTO.getWriter());
		st.setString(3, communityCommentsDTO.getContents());
		result = st.executeUpdate();
		st.close();
		return result;
	}
	@Override
	public int update(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "update community_board_comments set contents=? where cnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, communityCommentsDTO.getContents());
		st.setInt(2, communityCommentsDTO.getCnum());
		result = st.executeUpdate();
		st.close();
		return result;
	}
	@Override
	public int delete(int cnum, Connection con) throws Exception {
		int result = 0;
		String sql = "delete community_board_comments where cnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, cnum);
		result = st.executeUpdate();
		st.close();
		return result;
	}
}

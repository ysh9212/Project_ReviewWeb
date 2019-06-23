package com.project.news.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.community.comments.CommunityCommentsDAO;
import com.project.community.comments.CommunityCommentsDTO;
import com.project.shopPage.SearchRow;

public class NewsCommentsDAO implements CommunityCommentsDAO{

	@Override
	public List<CommunityCommentsDTO> selectList(SearchRow searchRow, int no, Connection con) throws Exception {
		List<CommunityCommentsDTO> ar = new ArrayList<CommunityCommentsDTO>();
		String sql ="select * from "
				+ "(select rownum R, C.* from "
				+ "(select * from News_Comments where no=? order by cnum desc) C) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			NewsCommentsDTO newsCommentsDTO = new NewsCommentsDTO();
			newsCommentsDTO.setCnum(rs.getInt("cnum"));
			newsCommentsDTO.setNo(rs.getInt("no"));
			newsCommentsDTO.setWriter(rs.getString("writer"));
			newsCommentsDTO.setContents(rs.getString("contents"));
			newsCommentsDTO.setReg_date(rs.getString("reg_date"));
			ar.add(newsCommentsDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	@Override
	public int insert(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into news_Comments values(community_board_comments_seq.nextval,?,?,?,sysdate)";
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
		String sql = "update news_Comments set contents=? where cnum=?";
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
		String sql = "delete news_Comments where cnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, cnum);
		result = st.executeUpdate();
		st.close();
		return result;
	}
}

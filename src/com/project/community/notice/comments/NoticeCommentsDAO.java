package com.project.community.notice.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.community.board.comments.ComBoardCommentsDTO;
import com.project.community.comments.CommunityCommentsDAO;
import com.project.community.comments.CommunityCommentsDTO;
import com.project.shopPage.SearchRow;

public class NoticeCommentsDAO implements CommunityCommentsDAO{

	@Override
	public List<CommunityCommentsDTO> selectList(SearchRow searchRow, int no, Connection con) throws Exception {
		List<CommunityCommentsDTO> ar = new ArrayList<CommunityCommentsDTO>();
		String sql ="select * from "
				+ "(select rownum R, C.* from "
				+ "(select * from community_notice_comments where no=? order by cnum desc) C) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			NoticeCommentsDTO noticeCommentsDTO = new NoticeCommentsDTO();
			noticeCommentsDTO.setCnum(rs.getInt("cnum"));
			noticeCommentsDTO.setNo(rs.getInt("no"));
			noticeCommentsDTO.setWriter(rs.getString("writer"));
			noticeCommentsDTO.setContents(rs.getString("contents"));
			noticeCommentsDTO.setReg_date(rs.getString("reg_date"));
			ar.add(noticeCommentsDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	@Override
	public int insert(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into community_notice_comments values(community_notice_comments_seq.nextval,?,?,?,sysdate)";
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
		String sql = "update community_notice_comments set contents=? where cnum=?";
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
		String sql = "delete community_notice_comments where cnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, cnum);
		result = st.executeUpdate();
		st.close();
		return result;
	}
}

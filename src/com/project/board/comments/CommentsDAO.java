package com.project.board.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.shopPage.SearchRow;


public class CommentsDAO {

	//insert
	public int insert(CommentsDTO commentsDTO, Connection con) throws Exception{
		int result=0;
		String sql = "insert into shop_notice_comments values(comments_seq.nextval,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, commentsDTO.getNo());
		st.setString(2, commentsDTO.getWriter());
		st.setString(3, commentsDTO.getContents());
		
		result = st.executeUpdate();
		
		st.close();
		return result;
	}
	
	//delete
	public int delete(int cno, Connection con) throws Exception{
		int result = 0;
		String sql = "delete shop_notice_comments where cno=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, cno);
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	
	//update
	public int Update(CommentsDTO commentsDTO, Connection con) throws Exception{
		int result = 0;
		String sql = "update shop_notice_comments set contents=? where cno=?";
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, commentsDTO.getContents());
		st.setInt(2, commentsDTO.getCno());
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	
	//list
	public List<CommentsDTO> selectList(SearchRow searchRow, int no, Connection con) throws Exception{
		List<CommentsDTO> ar = new ArrayList<CommentsDTO>();
		String sql = "select * from "
				+ "(select rownum R, C.* from "
				+ "(select * from shop_notice_comments where no=? order by cno desc) C) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setCno(rs.getInt("cno"));
			commentsDTO.setNo(rs.getInt("no"));
			commentsDTO.setWriter(rs.getString("writer"));
			commentsDTO.setContents(rs.getString("contents"));
			commentsDTO.setReg_date(rs.getString("reg_date"));
			ar.add(commentsDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	}
	
}

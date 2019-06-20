package com.project.review;

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
		String sql = "insert into REVIEW_comments values(REVIEW_seq.nextval,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, commentsDTO.getNum());
		st.setString(2, commentsDTO.getWriter());
		st.setString(3, commentsDTO.getContents());
		
		result = st.executeUpdate();
		
		st.close();
		return result;
	}
	
	//delete
	public int delete(int cnum, Connection con) throws Exception{
		int result= 0;
		String sql = "delete REVIEW_comments where cnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, cnum);
		
		st.close();
		return result;
	}
	
	//update
	public int update(CommentsDTO commentsDTO, Connection con) throws Exception{
		int result =0;
		String sql = "update REVIEW_comments set contents=? where cnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, commentsDTO.getContents());
		st.setInt(2, commentsDTO.getCnum());
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	
	//list
	public List<CommentsDTO> selectList(SearchRow searchRow, int num, Connection con)throws Exception{
		List<CommentsDTO> ar = new ArrayList<CommentsDTO>();
		String sql = "select * from "
				+ "(select rownum R, C.* from "
				+ "(select * from REVIEW_comments where num =? order by cnum desc) C) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setCnum(rs.getInt("cnum"));
			commentsDTO.setNum(rs.getInt("num"));
			commentsDTO.setContents(rs.getString("contents"));
			commentsDTO.setWriter(rs.getString("writer"));
			commentsDTO.setReg_date(rs.getString("reg_date"));
			ar.add(commentsDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	
	}
}

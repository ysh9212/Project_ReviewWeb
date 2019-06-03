package com.project.shop.qna.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommentsDAO {
	//insert
	public int insert(CommentsDTO commentsDTO, Connection con) throws Exception{
		int result=0;
		String sql = "insert into shop_qna_comments values(qna_seq.nextval,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, commentsDTO.getNum());
		st.setString(2, commentsDTO.getWriter());
		st.setString(3, commentsDTO.getContents());
		
		result = st.executeUpdate();
		
		st.close();
		return result;
	}
}

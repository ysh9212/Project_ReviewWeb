package com.project.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.project.util.DBConnector;

public class CommunityDAO {
	
	public ArrayList<CommunityDTO> List() throws Exception{
		ArrayList<CommunityDTO> ar = new ArrayList<CommunityDTO>();
		
		return ar;
	} 
	
	public int insert(CommunityDTO communityDTO) throws Exception{
		int result = 0;
		
		Connection con = DBConnector.getConnect();
		// String sql = "insert into community values(con_seq.nextval,?,?,?,?,sysdate)";
		String sql = "insert into community values(con_seq.nextval,?,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, communityDTO.getTitle());
		st.setString(2, communityDTO.getnName());
		st.setInt(3, communityDTO.getHit());
		st.setInt(4, communityDTO.getGood());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;
		
	}
}

package com.project.shop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

	//select
	public AdminDTO login(AdminDTO adminDTO,Connection con)throws Exception {
		String sql = "select * from admin where id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, adminDTO.getId());
		st.setString(2, adminDTO.getPw());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			adminDTO.setId(rs.getString("id"));
			adminDTO.setPw(rs.getString("pw"));
		}
		
		
		return adminDTO;
	}
}

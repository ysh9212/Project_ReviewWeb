package com.project.shop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

	//select
	public AdminDTO login(AdminDTO adminDTO,Connection con)throws Exception {
		String sql = "select * from admin where id=? and pw=?";
		AdminDTO dto = new AdminDTO();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, adminDTO.getId());
		st.setString(2, adminDTO.getPw());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
		}
		st.close();
		rs.close();
		
		return dto;
	}
}

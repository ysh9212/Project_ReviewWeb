package com.project.shop.product_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Product_CategoryDAO {
	//list
	public List<Product_CategoryDTO> selectList(Connection con) throws Exception{
		ArrayList<Product_CategoryDTO> ar = new ArrayList<Product_CategoryDTO>();
		
		String sql = "select * from product_category";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Product_CategoryDTO product_CategoryDTO = new Product_CategoryDTO();
			product_CategoryDTO.setCno(rs.getInt("cno"));
			product_CategoryDTO.setName(rs.getString("name"));
			ar.add(product_CategoryDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	}
}

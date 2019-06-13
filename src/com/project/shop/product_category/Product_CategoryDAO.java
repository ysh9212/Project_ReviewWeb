package com.project.shop.product_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Product_CategoryDAO {
	//list
	public ArrayList<Product_CategoryDTO> selectList(Connection con) throws Exception{
		ArrayList<Product_CategoryDTO> ar = new ArrayList<Product_CategoryDTO>();
		String sql = "select * from product_category";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Product_CategoryDTO product_CategoryDTO = new Product_CategoryDTO();
			product_CategoryDTO.setProduct_category_no(rs.getInt("product_category_no"));
			product_CategoryDTO.setPoduct_category_name(rs.getString("poduct_category_name"));
			ar.add(product_CategoryDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	}
}

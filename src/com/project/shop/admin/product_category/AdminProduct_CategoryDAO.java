package com.project.shop.admin.product_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.project.util.DBConnector;

public class AdminProduct_CategoryDAO {
	public int getNum() throws Exception{
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select product_category_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	//list
	public ArrayList<AdminProduct_CategoryDTO> selectList(Connection con) throws Exception{
		ArrayList<AdminProduct_CategoryDTO> ar = new ArrayList<AdminProduct_CategoryDTO>();
		String sql = "select * from product_category";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			AdminProduct_CategoryDTO product_CategoryDTO = new AdminProduct_CategoryDTO();
			product_CategoryDTO.setProduct_category_no(rs.getInt("product_category_no"));
			product_CategoryDTO.setPoduct_category_name(rs.getString("poduct_category_name"));
			ar.add(product_CategoryDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	}
	//select
	public AdminProduct_CategoryDTO selectOne(int product_category_no, Connection con)throws Exception{
	AdminProduct_CategoryDTO product_CategoryDTO = new AdminProduct_CategoryDTO();
	String sql = "select * from product_category where product_category_no=?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setInt(1, product_category_no);
	ResultSet rs = st.executeQuery();
	if(rs.next()) {
		product_CategoryDTO.setProduct_category_no(rs.getInt("product_category_no"));
		product_CategoryDTO.setPoduct_category_name(rs.getString("product_category_name"));
	}
	rs.close();
	st.close();
	return product_CategoryDTO;
	}
	//insert
	public int insert(AdminProduct_CategoryDTO product_CategoryDTO,Connection con) throws Exception{
		int result = 0;
		String sql = "insert into product_category values(product_seq.nextval,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, product_CategoryDTO.getPoduct_category_name());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
		
	}
	//delete 
	public int delete(int product_category_no, Connection con) throws Exception{
		int result = 0;
		String sql = "delete product_category where product_category_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_category_no);
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	//update
	public int update(AdminProduct_CategoryDTO product_CategoryDTO, Connection con)throws Exception{
		int result = 0;
		String sql = "update product_category set product_category_name=? where product_category_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, product_CategoryDTO.getPoduct_category_name());
		st.setInt(2, product_CategoryDTO.getProduct_category_no());
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
}

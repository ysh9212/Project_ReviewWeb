package com.project.shop.product_main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class Product_mainDAO {
	public int getNum() throws Exception{
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select product_main_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception{
		int result = 0;
		String sql = "select count(product_main_no) from product_main where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		return result;
	}
	
	//list
	public List<Product_mainDTO> selectList(SearchRow searchRow, Connection con) throws Exception{
		ArrayList<Product_mainDTO> ar = new ArrayList<Product_mainDTO>();

		String sql = "select * from " +
				"(select rownum R, p.* from " +
				"(select * from product_main where "+searchRow.getSearch().getKind()+" like ? order by product_main_no desc) p) "+
				"where R between ? and ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			Product_mainDTO product_mainDTO = new Product_mainDTO();
			product_mainDTO.setProduct_main_no(rs.getInt("product_main_no"));
			product_mainDTO.setProduct_no(rs.getInt("product_no"));
			product_mainDTO.setProduct_category_no(rs.getInt("product_category_no"));
			product_mainDTO.setProduct_title(rs.getString("product_title"));
			product_mainDTO.setProduct_detail(rs.getString("product_detail"));
			product_mainDTO.setProduct_date(rs.getString("product_date"));
			product_mainDTO.setCart_no(rs.getInt("cart_no"));
			ar.add(product_mainDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	//select
	public Product_mainDTO selectOne(int product_main_no, Connection con) throws Exception{
		Product_mainDTO product_mainDTO = new Product_mainDTO();
		String sql = "select * from product_main where product_main_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, product_mainDTO.getProduct_main_no());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			product_mainDTO.setProduct_main_no(rs.getInt("product_main_no"));
			product_mainDTO.setProduct_no(rs.getInt("product_no"));
			product_mainDTO.setProduct_category_no(rs.getInt("product_category_no"));
			product_mainDTO.setProduct_title(rs.getString("product_title"));
			product_mainDTO.setProduct_detail(rs.getString("product_detail"));
			product_mainDTO.setProduct_date(rs.getString("product_date"));
			product_mainDTO.setCart_no(rs.getInt("cart_no"));
		}
		rs.close();
		st.close();
		
		return product_mainDTO;
	}
	
	//insert
	public int insert(Product_mainDTO product_mainDTO, Connection con) throws Exception{
		int result =0;
		String sql = "insert into product_main values(product_main_seq.nextval,?,?,?,?,?,?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_mainDTO.getProduct_no());
		st.setInt(2, product_mainDTO.getProduct_category_no());
		st.setString(3, product_mainDTO.getProduct_title());
		st.setString(4, product_mainDTO.getProduct_detail());
		st.setString(5, product_mainDTO.getProduct_date());
		st.setInt(6, product_mainDTO.getCart_no());
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
	
	//delete
	public int delete(int product_main_no, Connection con) throws Exception{
		int result =0;
		String sql = "delete product_main where product_main_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_main_no);
		
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	//update
	public int update(Product_mainDTO product_mainDTO, Connection con) throws Exception{
		int result = 0;
		String sql = "update product_main set product_no=?, product_category_no=?, product_title=?,product_detail=?, cart_no=? where product_main_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_mainDTO.getProduct_no());
		st.setInt(2, product_mainDTO.getProduct_category_no());
		st.setString(3, product_mainDTO.getProduct_title());
		st.setString(4, product_mainDTO.getProduct_detail());
		st.setInt(5, product_mainDTO.getCart_no());
		st.setInt(6, product_mainDTO.getProduct_main_no());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	

}

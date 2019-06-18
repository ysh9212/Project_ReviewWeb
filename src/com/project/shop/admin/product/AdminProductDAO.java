package com.project.shop.admin.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class AdminProductDAO{
	
	public int getNum() throws Exception{
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select product_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception{
		int result = 0;
		String sql = "select count(product_no) from product where "+searchRow.getSearch().getKind()+" like ?";
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
	public List<AdminProductDTO> selectList(SearchRow searchRow, Connection con) throws Exception{
		ArrayList<AdminProductDTO> ar = new ArrayList<AdminProductDTO>();

		String sql = "select * from " +
				"(select rownum R, p.* from " +
				"(select * from product where "+searchRow.getSearch().getKind()+" like ? order by product_no desc) p) "+
				"where R between ? and ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			AdminProductDTO productDTO = new AdminProductDTO();
			productDTO.setProduct_no(rs.getInt("product_no"));
			productDTO.setProduct_color(rs.getString("product_color"));
			productDTO.setProduct_size(rs.getString("product_size"));
			productDTO.setProduct_stock(rs.getInt("product_stock"));
			productDTO.setProduct_price(rs.getInt("product_price"));
			ar.add(productDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	//select
	public AdminProductDTO selectOne(int product_no, Connection con) throws Exception{
		AdminProductDTO productDTO = new AdminProductDTO();
		String sql = "select * from product where product_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, product_no);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setProduct_no(rs.getInt("product_no"));
			productDTO.setProduct_color(rs.getString("product_color"));
			productDTO.setProduct_size(rs.getString("product_size"));
			productDTO.setProduct_stock(rs.getInt("product_stock"));
			productDTO.setProduct_price(rs.getInt("product_price"));
		}
		rs.close();
		st.close();
		
		return productDTO;
	}
	
	//insert
	public int insert(AdminProductDTO productDTO, Connection con) throws Exception{
		int result =0;
		String sql = "insert into product values(product_seq.nextval,?,?,?,?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, productDTO.getProduct_color());
		st.setString(2, productDTO.getProduct_size());
		st.setInt(3, productDTO.getProduct_stock());
		st.setInt(4, productDTO.getProduct_price());
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
	
	//delete
	public int delete(int product_no, Connection con) throws Exception{
		int result =0;
		String sql = "delete product where product_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_no);
		
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	//update
	public int update(AdminProductDTO productDTO, Connection con) throws Exception{
		int result = 0;
		String sql = "update product set product_color=?, product_size=?, product_stock=?,product_price=? where product_no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, productDTO.getProduct_color());
		st.setString(2, productDTO.getProduct_size());
		st.setInt(3, productDTO.getProduct_stock());
		st.setInt(4, productDTO.getProduct_price());
		st.setInt(5, productDTO.getProduct_no());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}

}

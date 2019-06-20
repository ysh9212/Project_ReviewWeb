package com.project.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
	public List<CartDTO> selectList(String id, Connection con) throws Exception{
		ArrayList<CartDTO> ar = new ArrayList<CartDTO>();
		String sql = "select * from cart where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setNo(rs.getInt("no"));
			cartDTO.setPno(rs.getInt("pno"));
			cartDTO.setId(rs.getString("id"));
			cartDTO.setCount(rs.getInt("count"));
			cartDTO.setPrice(rs.getInt("price"));
			ar.add(cartDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	}
	public CartDTO selectOne(int no,Connection con) throws Exception{
		CartDTO cartDTO = new CartDTO();
		String sql = "select * from cart where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			cartDTO.setNo(rs.getInt("no"));
			cartDTO.setPno(rs.getInt("pno"));
			cartDTO.setId(rs.getString("id"));
			cartDTO.setCount(rs.getInt("count"));
			cartDTO.setPrice(rs.getInt("price"));
		}
		rs.close();
		st.close();
		
		return cartDTO;
	}
	
	public int insert(CartDTO cartDTO, Connection con) throws Exception{
		int result = 0;
		String sql = "insert into cart values(cart_seq.nextval,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, cartDTO.getPno());
		st.setString(2, cartDTO.getId());
		st.setInt(3, cartDTO.getCount());
		st.setInt(4, cartDTO.getPrice());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	public int delete(int no,Connection con) throws Exception{
		int result = 0;
		String sql ="delete cart where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
}

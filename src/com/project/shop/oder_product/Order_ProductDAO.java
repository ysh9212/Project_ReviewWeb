package com.project.shop.oder_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.util.DBConnector;

public class Order_ProductDAO {
	public int getNum() throws Exception {
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql ="select order_product_seq.nextval from dual";
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
//insert
	public int insert(Order_ProductDTO order_ProductDTO,Connection con)throws Exception{
		int result = 0;
		String sql = "insert into order_product values(order_product_seq.nextval,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, order_ProductDTO.getPno());
		st.setInt(2, order_ProductDTO.getOno());
		st.setString(3, order_ProductDTO.getId());
		st.setInt(4, order_ProductDTO.getCount());
		st.setInt(5, order_ProductDTO.getPrice());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
//select
	public Order_ProductDTO selectOne(int opno, Connection con) throws Exception{
		Order_ProductDTO order_ProductDTO = new Order_ProductDTO();
		String sql = "select * from order_product where opno=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, opno);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			order_ProductDTO.setOpno(rs.getInt("opno"));
			order_ProductDTO.setPno(rs.getInt("pno"));
			order_ProductDTO.setOno(rs.getInt("ono"));
			order_ProductDTO.setId(rs.getString("id"));
			order_ProductDTO.setCount(rs.getInt("count"));
			order_ProductDTO.setPrice(rs.getInt("price"));
		}
		
		rs.close();
		st.close();
		return order_ProductDTO;
	}
	
//delete

}

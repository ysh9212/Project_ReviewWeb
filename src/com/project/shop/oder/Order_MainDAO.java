package com.project.shop.oder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.util.DBConnector;

public class Order_MainDAO {
	public int getNum() throws Exception {
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql ="select order_main_seq.nextval from dual";
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	//insert
	public int insert(Order_MainDTO order_MainDTO,Connection con) throws Exception{
		int result = 0;
		String sql = "insert into order_main values(?,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, order_MainDTO.getOno());
		st.setInt(2, order_MainDTO.getPno());
		st.setString(3, order_MainDTO.getId());
		st.setString(4, order_MainDTO.getState());
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
	//delete
	public int delete(int ono, Connection con)throws Exception{
		int result = 0;
		String sql ="delete order_main where ono=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, ono);
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
	//select
	public Order_MainDTO selectOne(int ono, Connection con)throws Exception{
		Order_MainDTO order_MainDTO = new Order_MainDTO();
		String sql = "select * from order_main where ono=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, ono);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			order_MainDTO.setOno(rs.getInt("ono"));
			order_MainDTO.setId(rs.getString("id"));
			order_MainDTO.setPno(rs.getInt("pno"));
			order_MainDTO.setState(rs.getString("state"));
			order_MainDTO.setOrder_date(rs.getString("order_date"));
		}
		rs.close();
		st.close(); 
		return order_MainDTO;
	}
	
	//list
}

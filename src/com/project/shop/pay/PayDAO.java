package com.project.shop.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.project.util.DBConnector;

public class PayDAO {
	public int getNum() throws Exception {
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql ="select pay_seq.nextval from dual";
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	//insert
	public int insert(PayDTO payDTO,Connection con)throws Exception{
		int result = 0;
		String sql = "insert into pay values(?, ?,sysdate,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, payDTO.getPno());
		st.setString(2, payDTO.getOpt());
		st.setInt(3, payDTO.getPrice());
		
		result = st.executeUpdate();
		
		st.close();
		return result;
	}
	//delete
	public int delete (int pno, Connection con) throws Exception{
		int result = 0;
		String sql = "delete pay where pno=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pno);
		result = st.executeUpdate();
		
		st.close();
		return result;
	}
	//select
	public PayDTO selectOne(int pno, Connection con)throws Exception{
		PayDTO payDTO = new PayDTO();
		String sql = "select * from pay where pno=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pno);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			payDTO.setPno(rs.getInt("pno"));
			payDTO.setOpt(rs.getString("opt"));
			payDTO.setPay_date(rs.getString("pay_date"));
			payDTO.setPrice(rs.getInt(rs.getInt("price")));
		}
		
		rs.close();
		st.close();
		
		return payDTO;
	}
	public List<PayDTO> selectList(Connection con)throws Exception{
		List<PayDTO> ar = null;
		String sql ="select * from pay";
		
		return ar;
	}
	
	
}

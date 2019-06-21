package com.project.shop.product_upload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Product_UploadDAO {
	//insert
	public int insert(Product_UploadDTO product_UploadDTO, Connection con)throws Exception{
		int result = 0;
		String sql = "insert into product_upload values(product_seq.nextval,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_UploadDTO.getNo());
		st.setString(2, product_UploadDTO.getOname());
		st.setString(3, product_UploadDTO.getFname());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	
	//select
	public Product_UploadDTO selectOne(int no, Connection con) throws Exception{
		Product_UploadDTO product_UploadDTO = null;
		String sql = "select * from product_upload where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			product_UploadDTO = new Product_UploadDTO();
			product_UploadDTO.setPno(rs.getInt("pno"));
			product_UploadDTO.setNo(rs.getInt("no"));
			product_UploadDTO.setOname(rs.getString("oname"));
			product_UploadDTO.setFname(rs.getString("fname"));
		}
		rs.close();
		st.close();
		
		return product_UploadDTO;
	}
	//selectList
	public List<Product_UploadDTO> selectList(int no, Connection con) throws Exception{
		ArrayList<Product_UploadDTO> ar = new ArrayList<Product_UploadDTO>();
		String sql = "select * from product_upload where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
			product_UploadDTO.setPno(rs.getInt("pno"));
			product_UploadDTO.setNo(rs.getInt("no"));
			product_UploadDTO.setOname(rs.getString("oname"));
			product_UploadDTO.setFname(rs.getString("fname"));
			ar.add(product_UploadDTO);
		}
		rs.close();
		st.close();
		
		return ar;
	}
	//delete
	public int delete(int pno, Connection con) throws Exception{
		int result = 0;
		String sql = "delete product_upload where pno=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pno);
		st.close();
		
		return result;
	}
}

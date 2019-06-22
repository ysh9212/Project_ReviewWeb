package com.project.shop.admin.product_upload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Product_UploadDAO {
	public int insert(Product_UploadDTO product_UploadDTO, Connection con)throws Exception{
		int result = 0;
		String sql = "insert into product_upload values(product_upload_seq.nextval,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, product_UploadDTO.getPno());
		st.setString(2, product_UploadDTO.getOname());
		st.setString(3, product_UploadDTO.getFname());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	public Product_UploadDTO selectOne(int pno,Connection con) throws Exception{
		String sql = "select * from product_upload where pno=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pno);
		ResultSet rs = st.executeQuery();
		Product_UploadDTO product_UploadDTO = null;
		if(rs.next()) {
			product_UploadDTO = new Product_UploadDTO();
			product_UploadDTO.setNo(rs.getInt("no"));
			product_UploadDTO.setPno(rs.getInt("pno"));
			product_UploadDTO.setOname(rs.getString("oname"));
			product_UploadDTO.setFname(rs.getString("fname"));
		}
		rs.close();
		st.close();
		
		return product_UploadDTO;
	}
	public List<Product_UploadDTO> selectList(Connection con) throws Exception{
	      ArrayList<Product_UploadDTO> ar = new ArrayList<Product_UploadDTO>();
	      String sql = "select * from product_upload";
	      PreparedStatement st = con.prepareStatement(sql);
	      ResultSet rs = st.executeQuery();
	      while(rs.next()) {
	    	  Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
	    	  product_UploadDTO.setNo(rs.getInt("no"));
	    	  product_UploadDTO.setPno(rs.getInt("pno"));
	    	  product_UploadDTO.setOname(rs.getString("oname"));
	    	  product_UploadDTO.setFname(rs.getString("fname"));
	         ar.add(product_UploadDTO);
	      }
	      rs.close();
	      st.close();
	      return ar;
	}
	public int delete(int no, Connection con) throws Exception{
		int result = 0;
		String sql = "delete product_upload where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	public int update(Product_UploadDTO product_UploadDTO,Connection con) throws Exception{
		int result = 0;
		String sql = "update product_upload set fname=?, oname=? where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, product_UploadDTO.getFname());
		st.setString(2, product_UploadDTO.getOname());
		st.setInt(3, product_UploadDTO.getNo());
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	
}

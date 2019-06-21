package com.project.shop.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ProductDAO{
	public int getNum() throws Exception {
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql ="select product_seq.nextval from dual";
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		int result=0;
		String sql ="select count(pno) from product where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		return result;
	}
	
	public List<ProductDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		String sql = "select * from " + 
				"(select rownum R, p.* from " + 
				"(select * from product where "+searchRow.getSearch().getKind()+" like ? order by pno desc) p) " + 
				"where R between ? and ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setPno(rs.getInt("pno"));
			productDTO.setCno(rs.getInt("cno"));
			productDTO.setTitle(rs.getString("title"));
			productDTO.setDetail(rs.getString("detail"));
			productDTO.setReg_date(rs.getString("reg_date"));
			productDTO.setPrice(rs.getInt("price"));
			productDTO.setStock(rs.getInt("stock"));
			ar.add(productDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	
	public ProductDTO selectOne(int pno, Connection con) throws Exception{
		ProductDTO productDTO = new ProductDTO();
		String sql = "select * from product where pno=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, pno);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setPno(rs.getInt("pno"));
			productDTO.setCno(rs.getInt("cno"));
			productDTO.setTitle(rs.getString("title"));
			productDTO.setDetail(rs.getString("detail"));
			productDTO.setReg_date(rs.getString("reg_date"));
			productDTO.setStock(rs.getInt(rs.getInt("stock")));
			productDTO.setPrice(rs.getInt("price"));
		}
		rs.close();
		st.close();
		
		return productDTO;
	}
	
	public int insert(ProductDTO productDTO, Connection con)throws Exception{
		int result = 0;
		String sql = "insert into product values(?,?,?,?,sysdate,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, productDTO.getPno());
		st.setInt(2, productDTO.getCno());
		st.setString(3, productDTO.getTitle());
		st.setString(4, productDTO.getDetail());
		st.setInt(5, productDTO.getPrice());
		st.setInt(6, productDTO.getStock());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
		
}

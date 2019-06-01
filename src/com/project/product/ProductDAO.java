package com.project.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ProductDAO{
	
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
		String sql = "select count(pnum) from product where "+searchRow.getSearch().getKind()+" like ?";
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
	public List<ProductDTO> selectList(SearchRow searchRow, Connection con) throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();

		String sql = "select * from " +
				"(select rownum R, p.* from " +
				"(select * from product where "+searchRow.getSearch().getKind()+" like ? order by num desc) p) "+
				"where R between ? and ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setPnum(rs.getInt("num"));
			productDTO.setPcategory_num(rs.getInt("pcategory_num"));
			productDTO.setPname(rs.getString("pname"));
			productDTO.setPcontents(rs.getString("pcontents"));
			productDTO.setPrice(rs.getInt("price"));
			productDTO.setPcount(rs.getInt("pcount"));
			productDTO.setPreg_date(rs.getString("preg_date"));
			ar.add(productDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	//select
	public ProductDTO selectOne(int pnum, Connection con) throws Exception{
		ProductDTO productDTO = new ProductDTO();
		String sql = "select * from product where pnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, productDTO.getPnum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setPnum(rs.getInt("pnum"));
			productDTO.setPcategory_num(rs.getInt("pcategory_num"));
			productDTO.setPname(rs.getString("pname"));
			productDTO.setPcontents(rs.getString("pcontents"));
			productDTO.setPrice(rs.getInt("price"));
			productDTO.setPcount(rs.getInt("pcount"));
			productDTO.setPreg_date(rs.getString("preg_date"));
		}
		rs.close();
		st.close();
		
		return productDTO;
	}
	
	//insert
	public int insert(ProductDTO productDTO, Connection con) throws Exception{
		int result =0;
		String sql = "insert into product values(pcategory_num,?,?,?,?,?,sysdate";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, productDTO.getPcategory_num());
		st.setString(2, productDTO.getPname());
		st.setString(3, productDTO.getPcontents());
		st.setInt(4, productDTO.getPrice());
		st.setInt(5, productDTO.getPcount());
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
	
	//delete
	public int delete(int pnum, Connection con) throws Exception{
		int result =0;
		String sql = "delete product where pnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pnum);
		
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	//update
	public int update(ProductDTO productDTO, Connection con) throws Exception{
		int result = 0;
		String sql = "update product set pcategory_num=?, pname=?, pcontents=?, price=?,pcount=? where pnum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, productDTO.getPcategory_num());
		st.setString(2, productDTO.getPname());
		st.setString(3, productDTO.getPcontents());
		st.setInt(4, productDTO.getPrice());
		st.setInt(5, productDTO.getPcount());
		st.setInt(6, productDTO.getPnum());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}

}

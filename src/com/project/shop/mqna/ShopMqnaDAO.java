package com.project.shop.mqna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ShopMqnaDAO implements BoardDAO {

	@Override
	public int getNum() throws Exception {
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql = "select shop_mqna_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		int result=0;
		String sql = "select count(no) from shop_mqna where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		
		return result;
	}

	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		String sql = "select * from " + 
				"(select rownum R, p.* from " + 
				"(select * from shop_mqna where "+searchRow.getSearch().getKind()+" like ? order by no desc) p) " + 
				"where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ShopMqnaDTO shopMqnaDTO = new ShopMqnaDTO();
			shopMqnaDTO.setNo(rs.getInt("no"));
			shopMqnaDTO.setTitle(rs.getString("title"));
			shopMqnaDTO.setContents(rs.getString("contents"));
			shopMqnaDTO.setWriter(rs.getString("writer"));
			shopMqnaDTO.setReg_date(rs.getString("reg_date"));
			shopMqnaDTO.setHit(rs.getInt("hit"));
			shopMqnaDTO.setRecommend(rs.getInt("recommend"));
			shopMqnaDTO.setDecommend(rs.getInt("decommend"));
			ar.add(shopMqnaDTO);
		}
		rs.close();
		st.close();
		
		
		return ar;
	}

	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		ShopMqnaDTO shopMqnaDTO = new ShopMqnaDTO();
		
		String sql = "select * from shop_mqna where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, no);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			shopMqnaDTO.setNo(rs.getInt("no"));
			shopMqnaDTO.setTitle(rs.getString("title"));
			shopMqnaDTO.setContents(rs.getString("contents"));
			shopMqnaDTO.setWriter(rs.getString("writer"));
			shopMqnaDTO.setReg_date(rs.getString("reg_date"));
			shopMqnaDTO.setHit(rs.getInt("hit"));
			shopMqnaDTO.setRecommend(rs.getInt("recommend"));
			shopMqnaDTO.setDecommend(rs.getInt("decommend"));
		}
		rs.close();
		st.close();
		
		return shopMqnaDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHit(int no, Connection con) throws Exception {
		String sql = "update shop_mqna set hit = hit+'1' where no =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return result;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.project.shop.admin.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class AdminShopQnaDAO implements BoardDAO{

	@Override
	public int getNum() throws Exception {
		int result=0;
		Connection con = DBConnector.getConnect();
		String sql ="select shop_qna_seq.nextval from dual";
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		int result=0;
		String sql ="select count(no) from shop_qna where "+searchRow.getSearch().getKind()+" like ?";
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
				"(select * from shop_qna where "+searchRow.getSearch().getKind()+" like ? order by no desc) p) " + 
				"where R between ? and ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			AdminShopQnaDTO adminShopQnaDTO = new AdminShopQnaDTO();
			adminShopQnaDTO.setNo(rs.getInt("no"));
			adminShopQnaDTO.setTitle(rs.getString("title"));
			adminShopQnaDTO.setContents(rs.getString("contents"));
			adminShopQnaDTO.setWriter(rs.getString("writer"));
			adminShopQnaDTO.setReg_date(rs.getString("reg_date"));
			adminShopQnaDTO.setHit(rs.getInt("hit"));
			adminShopQnaDTO.setRecommend(rs.getInt("recommend"));
			adminShopQnaDTO.setDecommend(rs.getInt("decommend"));
			ar.add(adminShopQnaDTO);
		}
		rs.close();
		st.close();
		return ar;
	}

	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		AdminShopQnaDTO adminShopQnaDTO = new AdminShopQnaDTO();
		
		String sql = "select * from shop_qna where no=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, no);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			adminShopQnaDTO.setNo(rs.getInt("no"));
			adminShopQnaDTO.setTitle(rs.getString("title"));
			adminShopQnaDTO.setContents(rs.getString("contents"));
			adminShopQnaDTO.setWriter(rs.getString("writer"));
			adminShopQnaDTO.setReg_date(rs.getString("reg_date"));
			adminShopQnaDTO.setHit(rs.getInt("hit"));
			adminShopQnaDTO.setRecommend(rs.getInt("recommend"));
			adminShopQnaDTO.setDecommend(rs.getInt("decommend"));
		}
		rs.close();
		st.close();
		
		return adminShopQnaDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into shop_qna values(shop_qna_seq.nextval,?,?,?,sysdate,0,0,0)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setString(3, boardDTO.getWriter());
		result = st.executeUpdate();
		st.close();
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "update shop_qna set title=?, contents=? where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNo());
		
		result = st.executeUpdate();
		st.close();
		return result;
	}

	@Override
	public int updateHit(int no, Connection con) throws Exception {
		int result = 0;
		String sql = "update shop_qna set hit = hit+'1' where no=?";
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1, no);
		result = st.executeUpdate();
		st.close();
		
		return result;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		int result = 0;
		String sql = "delete shop_qna where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		result = st.executeUpdate();
		st.close();
		return result;
	}

}

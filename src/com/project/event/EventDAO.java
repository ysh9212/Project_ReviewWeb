package com.project.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class EventDAO implements BoardDAO {

	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select board_seq.nextval from dual";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);

		return result;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		int result = 0;
		String sql = "select count(no) from Event where " + searchRow.getSearch().getKind() + " like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + searchRow.getSearch().getSearch() + "%");
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
				"(select rownum R, N.* from "
				+ "(select no, title, writer, reg_date, hit from event where " + searchRow.getSearch().getKind()
				+ " like ? order by no desc) N) " + "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + searchRow.getSearch().getSearch() + "%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			EventDTO eventDTO = new EventDTO();
			eventDTO.setNo(rs.getInt("no"));
			eventDTO.setTitle(rs.getString("title"));
			eventDTO.setWriter(rs.getString("writer"));
			eventDTO.setReg_date(rs.getString("reg_date"));
			eventDTO.setHit(rs.getInt("hit"));
			ar.add(eventDTO);

		}

		rs.close();
		st.close();

		return ar;
	}

	@Override
	public BoardDTO selectOne(int num, Connection con) throws Exception {
		EventDTO eventDTO = null;
		String sql = "select * from news where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			eventDTO = new EventDTO();
			eventDTO.setNo(rs.getInt("no"));
			eventDTO.setTitle(rs.getString("title"));
			eventDTO.setContents(rs.getString("contents"));
			eventDTO.setWriter(rs.getString("writer"));
			eventDTO.setReg_date(rs.getString("reg_date"));
			eventDTO.setHit(rs.getInt("hit"));
		}

		rs.close();
		st.close();

		return eventDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;

		String sql = "insert into event values(?,?,?,?, sysdate,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, boardDTO.getNo());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		st.setString(4, boardDTO.getWriter());
		result = st.executeUpdate();
		st.close();
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHit(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
package com.project.community.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.page.SearchRow;

public class NoticeDAO implements BoardDAO{
	
	@Override
	public int getNum() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from community_noitce";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO  = new BoardDTO();
			boardDTO.setNo(rs.getInt("no"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setDate(rs.getDate("date"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setRecommend(rs.getInt("recommand"));
			boardDTO.setDecommend(rs.getInt("decommand"));
			boardDTO.setContents(rs.getString("contents"));
			ar.add(boardDTO);	
		}
		rs.close();
		st.close();
		return ar;
	}

	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into community_notice values(notice_seq.nextval,?,?,sysdate,0,0,0,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		result = st.executeUpdate();
		st.close();
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "update community_notice set contents=? where no=?";
		
		return result;
	}

	@Override
	public int delete(int no, Connection con) throws Exception {
		int result = 0;
		String sql = "delete community_notice where no = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.close();
		return result;
	}
	

}

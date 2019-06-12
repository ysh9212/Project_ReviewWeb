package com.project.community.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.community.board.ComBoardDTO;
import com.project.shopPage.Search;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class NoticeDAO implements BoardDAO{
	
	// 여기에 private NoticeDTO noticeDTO 선언해서 사용해도 되지 않나?;
	// Q : private 생성자
	
	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select community_seq.nextval from dual";
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
		String sql ="select count(no) from community_board where "+searchRow.getSearch().getKind()+" like ?";
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
		String sql = "select no, title, writer, reg_date, hit, recommend, decommend from community_notice";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setRecommend(rs.getInt("recommend"));
			noticeDTO.setDecommend(rs.getInt("decommend"));
			ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	@Override
	public int updateHit(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		NoticeDTO noticeDTO = null;
		String sql = "select * from community_notice where no = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, noticeDTO.getNo());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setRecommend(rs.getInt("recommand"));
			noticeDTO.setDecommend(rs.getInt("decommand"));
			noticeDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return noticeDTO;
	}
	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		NoticeDTO noticeDTO = null;
		String sql = "insert into community_notice values(notice_seq.nextval,?,?,sysdate,0,0,0,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		result = st.executeUpdate();
		st.close();
		return result;
	}
	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		NoticeDTO noticeDTO = null;
		String sql = "update community_notice set contents=? where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getContents());
		st.setInt(2, noticeDTO.getNo());
		result = st.executeUpdate();
		st.close();
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

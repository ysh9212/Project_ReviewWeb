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
	public List<BoardDTO> AdList(SearchRow searchRow, Connection con)throws Exception{
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from " + 
				"(select rownum R, p.* from " + 
				"(select * from community_notice where "+searchRow.getSearch().getKind()+" like ? order by no desc) p) " + 
				"where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ComBoardDTO comBoardDTO = new ComBoardDTO();
			comBoardDTO.setNo(rs.getInt("no"));
			comBoardDTO.setTitle(rs.getString("title"));
			comBoardDTO.setWriter(rs.getString("writer"));
			comBoardDTO.setReg_date(rs.getString("reg_date"));
			comBoardDTO.setHit(rs.getInt("hit"));
			comBoardDTO.setRecommend(rs.getInt("recommend"));
			comBoardDTO.setDecommend(rs.getInt("decommend"));
			ar.add(comBoardDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	public List<BoardDTO> List(Connection con)throws Exception{
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select title, no from community_notice where rownum <=5 order by no desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle(rs.getString("title"));
		noticeDTO.setNo(rs.getInt("no"));
		ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	
	// �ʱ� �Խñ� ��� ����;
	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from " + 
				"(select rownum R, p.* from " + 
				"(select * from community_notice where "+searchRow.getSearch().getKind()+" like ? order by no desc) p) " + 
				"where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	// �Խñ� ����Ȯ��;
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		String sql = "select * from community_notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setRecommend(rs.getInt("recommend"));
			noticeDTO.setDecommend(rs.getInt("decommend"));
			noticeDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return noticeDTO;
	}
	@Override
	public int updateHit(int no, Connection con) throws Exception {
		String sql = "update community_notice set hit = hit+'1' where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return 0;
	}
	// ��� ����.
	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		return 0;
	}
	@Override
	public int update(BoardDTO boardDTO, Connection con) throws Exception {
		return 0;
	}
	@Override
	public int delete(int no, Connection con) throws Exception {
		return 0;
	}
}

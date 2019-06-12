package com.project.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.community.board.ComBoardDTO;
import com.project.community.bug.BugDTO;
import com.project.community.notice.NoticeDTO;
import com.project.community.qna.QnaDTO;
import com.project.community.review.ReviewDTO;
import com.project.community.used.UsedDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class CommunityDAO implements BoardDAO{

	// ��ú����� �Խñ��� �ҷ����µ��� ����;
	
	// ��������;
	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select title from community_notice order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}
	// �����Խ���;
	public List<ComBoardDTO> noticeList(Connection con) throws Exception{
		ArrayList<ComBoardDTO> ar = new ArrayList<ComBoardDTO>();
		String sql = "select title from community_board order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ComBoardDTO comBoardDTO = new ComBoardDTO();
			comBoardDTO.setTitle(rs.getString("title"));
		}
		return ar;
	}
	public int boardGetTotalCount(SearchRow searchRow, Connection con) throws Exception{
		int result=0;
		String sql = "select count(no) from community_board where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		return result;
	}
	// ��������;
	public List<ReviewDTO> reviewList(SearchRow searchRow, Connection con) throws Exception{
		List<ReviewDTO> ar = new ArrayList<ReviewDTO>();
		String sql = "select title from community_review order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}
	// �߰�����; - ������ �������� ������ sql�� ������ �ʿ���;
	public List<UsedDTO> usedList(SearchRow searchRow, Connection con) throws Exception{
		List<UsedDTO> ar = new ArrayList<UsedDTO>();
		String sql = "select title from community_used order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}
	
	// �Խñ۷� �̵�;
	
	// �����Խ���;
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		String sql = "select * from community_notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			boardDTO.setNo(rs.getInt("no"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setReg_date(rs.getString("reg_date"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setRecommend(rs.getInt("recommend"));
			boardDTO.setDecommend(rs.getInt("decommend"));
			boardDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return boardDTO;
	}
	// ��������;
	public NoticeDTO boardSelectOne(int no, Connection con) throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		String sql = "select * from community_board where no=?";
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
	// ��������;
	public ReviewDTO reviewSelectOne(int no, Connection con) throws Exception {
		ReviewDTO reviewDTO = new ReviewDTO();
		String sql = "select * from community_review where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			reviewDTO.setNo(rs.getInt("no"));
			reviewDTO.setTitle(rs.getString("title"));
			reviewDTO.setWriter(rs.getString("writer"));
			reviewDTO.setReg_date(rs.getString("reg_date"));
			reviewDTO.setHit(rs.getInt("hit"));
			reviewDTO.setRecommend(rs.getInt("recommend"));
			reviewDTO.setDecommend(rs.getInt("decommend"));
			reviewDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return reviewDTO;
	}
	// ���׸���Ʈ;
	public BugDTO bugSelectOne(int no, Connection con) throws Exception {
		BugDTO bugDTO = new BugDTO();
		String sql = "select * from community_bug where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bugDTO.setNo(rs.getInt("no"));
			bugDTO.setTitle(rs.getString("title"));
			bugDTO.setWriter(rs.getString("writer"));
			bugDTO.setReg_date(rs.getString("reg_date"));
			bugDTO.setHit(rs.getInt("hit"));
			bugDTO.setRecommend(rs.getInt("recommend"));
			bugDTO.setDecommend(rs.getInt("decommend"));
			bugDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return bugDTO;
	}
	// �߰�����;
	public UsedDTO usedSelectOne(int no, Connection con) throws Exception {
		UsedDTO usedDTO = new UsedDTO();
		String sql = "select * from community_used where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			usedDTO.setNo(rs.getInt("no"));
			usedDTO.setTitle(rs.getString("title"));
			usedDTO.setWriter(rs.getString("writer"));
			usedDTO.setReg_date(rs.getString("reg_date"));
			usedDTO.setHit(rs.getInt("hit"));
			usedDTO.setRecommend(rs.getInt("recommend"));
			usedDTO.setDecommend(rs.getInt("decommend"));
			usedDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return usedDTO;
	}

	
	// �Ⱦ�
	@Override
	public int getNum() throws Exception {
		return 0;
	}
	@Override
	public int getTotalCount(SearchRow searchRow, Connection con) throws Exception {
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}

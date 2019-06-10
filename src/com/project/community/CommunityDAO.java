package com.project.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.community.board.cBoardDTO;
import com.project.community.bug.BugDTO;
import com.project.community.notice.NoticeDTO;
import com.project.community.qna.QnaDTO;
import com.project.community.review.ReviewDTO;
import com.project.community.used.UsedDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class CommunityDAO implements BoardDAO{

	// ����Ʈ �ҷ�����
	
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
	public List<cBoardDTO> noticeList(SearchRow searchRow, Connection con) throws Exception{
		List<cBoardDTO> ar = new ArrayList<cBoardDTO>();
		String sql = "select title from community_board order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
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
	
	// �Խñ� �̵�;
	
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
			// reviewDTO.setContents(rs.getString("contents"));
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
			
		}
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
			
		}
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

package com.project.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.community.notice.NoticeDTO;
import com.project.community.qna.QnaDTO;
import com.project.community.used.UsedDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class CommunityDAO implements BoardDAO{

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
	// 자유게시판 가져오는 용도;
	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select title from community_notice order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}
	
	// 자유게시판 가져오는 용도;
	public List<NoticeDTO> noticeList(SearchRow searchRow, Connection con) throws Exception{
		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		String sql = "select title from community_notice order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}
	
	// QnA 가저오는 용도;
	public List<QnaDTO> qnaList(SearchRow searchRow, Connection con) throws Exception{
		List<QnaDTO> ar = new ArrayList<QnaDTO>();
		String sql = "select title from community_qna order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
	}
	
	// used 가져오는 용도;
	public List<UsedDTO> usedList(SearchRow searchRow, Connection con) throws Exception{
		List<UsedDTO> ar = new ArrayList<UsedDTO>();
		String sql = "select title from community_used order by desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return ar;
		
	}
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

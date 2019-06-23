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

	// ��� ����;
	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
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

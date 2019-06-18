package com.project.community.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.board.BoardDAO;
import com.project.board.BoardDTO;
import com.project.community.notice.NoticeDTO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class QnaDAO implements BoardDAO{

	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select community_qna_seq.nextval from dual";
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
		String sql ="select count(no) from community_qna where "+searchRow.getSearch().getKind()+" like ?";
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
		String sql = "select no, title, writer, reg_date, hit from community_qna";
		PreparedStatement st = con.prepareStatement(sql);
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
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		String sql = "select * from community_qna where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			qnaDTO.setNo(rs.getInt("no"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setReg_date(rs.getString("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setRecommend(rs.getInt("recommend"));
			qnaDTO.setDecommend(rs.getInt("decommend"));
			qnaDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return qnaDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into community_qna values(community_qna_seq.nextval,?,?,?,sysdate,0,0,0)";
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
		String sql = "update community_qna set title=?, contents=? where no=?";
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
		String sql = "update community_qna set hit = hit+'1' where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return 0;
	}
	@Override
	public int delete(int no, Connection con) throws Exception {
		String sql = "delete community_qna where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return result;
	}
}

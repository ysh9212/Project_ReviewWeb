package com.project.community.bug;

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

public class BugDAO implements BoardDAO{
	@Override
	public int getNum() throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "select communityBug_seq.nextval from dual";
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
		String sql ="select count(no) from community_bug where "+searchRow.getSearch().getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		rs.close();
		st.close();
		return result;
	}
	public List<BoardDTO> List(Connection con)throws Exception{
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select title from community_bug where rownum <=5 order by no desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BugDTO bugDTO = new BugDTO();
			bugDTO.setTitle(rs.getString("title"));
			ar.add(bugDTO);
		}
		return ar;
	}
	// 초기 게시글 목록 나열;
	@Override
	public List<BoardDTO> selectList(SearchRow searchRow, Connection con) throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from " + 
				"(select rownum R, p.* from " + 
				"(select * from community_bug where "+searchRow.getSearch().getKind()+" like ? order by no desc) p) " + 
				"where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+searchRow.getSearch().getSearch()+"%");
		st.setInt(2, searchRow.getStartRow());
		st.setInt(3, searchRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BugDTO bugDTO = new BugDTO();
			bugDTO.setNo(rs.getInt("no"));
			bugDTO.setTitle(rs.getString("title"));
			bugDTO.setWriter(rs.getString("writer"));
			bugDTO.setReg_date(rs.getString("reg_date"));
			bugDTO.setHit(rs.getInt("hit"));
			ar.add(bugDTO);
		}
		rs.close();
		st.close();
		return ar;
	}
	// 게시글 내용 확인;
	@Override
	public BoardDTO selectOne(int no, Connection con) throws Exception {
		BugDTO bugDTO = new BugDTO();
		String sql = "select * from community_bug where no = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bugDTO = new BugDTO();
			bugDTO.setNo(rs.getInt("no"));
			bugDTO.setTitle(rs.getString("title"));
			bugDTO.setWriter(rs.getString("writer"));
			bugDTO.setReg_date(rs.getString("reg_date"));
			bugDTO.setHit(rs.getInt("hit"));
			bugDTO.setContents(rs.getString("contents"));
		}
		rs.close();
		st.close();
		return bugDTO;
	}

	// 사용안함;
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
		String sql = "update community_bug set hit = hit+'1' where no=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		int result = st.executeUpdate();
		st.close();
		return 0;
	}
	@Override
	public int delete(int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}

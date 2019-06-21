package com.project.community.notice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.board.BoardDTO;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchPager;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class NoticeService implements Action{
	private NoticeDAO noticeDAO;
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	// 처음 게시글 나열;
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int curPage = 1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		SearchMakePage s = new SearchMakePage(curPage, kind, search);
		SearchRow searchRow = s.makeRow();
		int totalCount = 0;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			List<BoardDTO> ar = noticeDAO.selectList(searchRow, con);
			totalCount = noticeDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "communityNotice");
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/community/notice/communityNotice.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../../index.do");
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/common/result.jsp");
		}
		return actionForward;
	}
	// 게시글 내용 확인;
	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		BoardDTO boardDTO = null;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			boardDTO = noticeDAO.selectOne(no, con);
			noticeDAO.updateHit(no, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String path = "";
		if(boardDTO != null) {
			request.setAttribute("dto", boardDTO);
			path = "../../WEB-INF/views/community/notice/communityNoticeSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./communityNotice");
			path="../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		return actionForward;
	}
	
	// 사용안함
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

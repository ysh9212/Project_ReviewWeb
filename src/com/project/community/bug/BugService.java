package com.project.community.bug;

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

public class BugService implements Action{
	private BugDAO bugDAO;
	public BugService() {
		bugDAO = new BugDAO();
	}
	// ó�� �Խñ� ����;
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
			List<BoardDTO> ar = bugDAO.selectList(searchRow, con);
			totalCount = bugDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "communityBug");
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/community/communityBoard/board.jsp");
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
	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		BoardDTO boardDTO = null;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			boardDTO = bugDAO.selectOne(no, con);
			bugDAO.updateHit(no, con);
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
			request.setAttribute("board", "communityBug");
			path = "../../WEB-INF/views/community/communityBoard/boardSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./board");
			path="../../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		return actionForward;
	}
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	public ActionForward recommend(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "";
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			result = bugDAO.recommend(no, con);
			request.setAttribute("result", result);
			check = true;
			path = "../../WEB-INF/views/community/communityBoard/result2.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
	public ActionForward decommend(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "";
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			result = bugDAO.decommend(no, con);
			request.setAttribute("result", result);
			check = true;
			path = "../../WEB-INF/views/community/communityBoard/result2.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
}

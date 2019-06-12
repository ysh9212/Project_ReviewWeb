package com.project.community.board;

import java.sql.Connection;
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

public class ComBoardService implements Action{
	private ComBoardDAO comBoardDAO;
	public ComBoardService() {
	comBoardDAO = new ComBoardDAO();	
	}
	

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
		
		// 1. row;
		SearchRow searchRow = s.makeRow();
		int totalCount = 0;
		Connection con = null;
		try {
		con = DBConnector.getConnect();
		List<BoardDTO> ar = comBoardDAO.selectList(searchRow, con);
		//2. page;
		totalCount = comBoardDAO.getTotalCount(searchRow, con);
		SearchPager searchPager = s.makePage(totalCount);
		
		request.setAttribute("bpager", searchPager);
		request.setAttribute("blist", ar);
		request.setAttribute("bboard", "bboard");
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/community/board/communityBoard.jsp");
		} catch (Exception e) {
			// TODO: handle exception
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/community/board/communityBoardWrite.jsp");
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/community/board/communityBoardUpdate.jsp");
		return actionForward;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/community/board/communityBoardDelete.jsp");
		return actionForward;
	}
	
}

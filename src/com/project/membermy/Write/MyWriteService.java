package com.project.membermy.Write;

import java.sql.*;
import java.util.*;

import javax.servlet.http.*;

import com.project.action.*;
import com.project.board.*;
import com.project.community.board.*;
import com.project.shopPage.*;
import com.project.util.*;

public class MyWriteService implements Action{
	private ComBoardDAO comBoardDAO;
	private MyWriteDAO myWriteDAO;
	
	public MyWriteService() {
		comBoardDAO = new ComBoardDAO();
		myWriteDAO = new MyWriteDAO();	
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
		// MemberDTO memberDTO = new MemberDTO();
		// memberDTO = (MemberDTO)(request.getSession().getAttribute("memberDTO"));
		
		// 1. row;
		SearchRow searchRow = s.makeRow();
		int totalCount = 0;
		Connection con = null;
		try {
		con = DBConnector.getConnect();
		String id = "sh";
		
		List<BoardDTO> ar = myWriteDAO.selectList(searchRow, id, con);
		//2. page;
		totalCount = comBoardDAO.getTotalCount(searchRow, con);
		SearchPager searchPager = s.makePage(totalCount);
		request.setAttribute("pager", searchPager);
		request.setAttribute("list", ar);
		request.setAttribute("board", "mywriteBoard");
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/views/memberMy/memberMyWrite.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../index.do");
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/views/common/result.jsp");
		}
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		BoardDTO boardDTO = null;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			boardDTO = comBoardDAO.selectOne(no, con);
			comBoardDAO.updateHit(no, con);
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
			path = "../WEB-INF/views/community/board/communityBoardSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "../WEB-INF/views/community/board/communityBoard");
			path="../WEB-INF/views/common/result.jsp";
		}
		actionforward.setCheck(true);
		actionforward.setPath(path);
		return actionforward;
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

}

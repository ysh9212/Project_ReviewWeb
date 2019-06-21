package com.project.review;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class CommentsService implements Action{
	private CommentsDAO commentsDAO;
	public CommentsService() {
		commentsDAO = new CommentsDAO();
	}
	
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int curPage = 1;
		int no = 0;
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		no = Integer.parseInt(request.getParameter("no"));
		
		SearchMakePage searchMakePage = new SearchMakePage(curPage, "", "");
		SearchRow searchRow = searchMakePage.makeRow();
		Connection con = null;
		List<CommentsDTO> ar = null;
		
		try {
			con = DBConnector.getConnect();
			ar = commentsDAO.selectList(searchRow, no, con);
		System.out.println(ar);
		} 
		
		catch (Exception e) {
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
		request.setAttribute("commentslist", ar);
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/common/list.jsp");
		
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
		CommentsDTO commentsDTO = new CommentsDTO();
		commentsDTO.setNo(Integer.parseInt(request.getParameter("no")));
		commentsDTO.setWriter(request.getParameter("writer"));
		commentsDTO.setContents(request.getParameter("contents"));
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			result = commentsDAO.insert(commentsDTO, con);
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
		request.setAttribute("result", result);
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/common/result2.jsp");
		
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		CommentsDTO commentsDTO = new CommentsDTO();
		commentsDTO.setCnum(Integer.parseInt(request.getParameter("cnum")));
		commentsDTO.setContents(request.getParameter("contents"));
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			result = commentsDAO.update(commentsDTO, con);
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
		request.setAttribute("result", result);
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/common/result2.jsp");
		
		return actionForward;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int result = 0;
		Connection con = null;
		
		try {
			int cnum = Integer.parseInt(request.getParameter("cnum"));
			con = DBConnector.getConnect();
			result = commentsDAO.delete(cnum, con);
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
		request.setAttribute("result", result);
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/common/result2.jsp");
		
		return actionForward;
	}

}

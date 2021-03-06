package com.project.community.review.comments;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.community.board.comments.ComBoardCommentsDTO;
import com.project.community.comments.CommunityCommentsDTO;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ReviewCommentsService implements Action{
	private ReviewCommentsDAO reviewCommentsDAO;
	public ReviewCommentsService() {
		reviewCommentsDAO = new ReviewCommentsDAO();
	}
	public ActionForward adminList(HttpServletRequest request, HttpServletResponse response) {
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
		List<CommunityCommentsDTO> ar = null;
		try {
			con=DBConnector.getConnect();
			ar = reviewCommentsDAO.selectList(searchRow, no, con);
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
		request.setAttribute("commentsList", ar);
		actionForward.setCheck(true);
		actionForward.setPath("#");
		return actionForward;
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
		List<CommunityCommentsDTO> ar = null;
		try {
			con=DBConnector.getConnect();
			ar = reviewCommentsDAO.selectList(searchRow, no, con);
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
		request.setAttribute("commentsList", ar);
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/community/communityCommon/list.jsp");
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
		ReviewCommentsDTO reviewCommentsDTO = new ReviewCommentsDTO();
		reviewCommentsDTO.setNo(Integer.parseInt(request.getParameter("no")));
		reviewCommentsDTO.setWriter(request.getParameter("writer"));
		reviewCommentsDTO.setContents(request.getParameter("contents"));
		int result = 0;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			result = reviewCommentsDAO.insert(reviewCommentsDTO, con);
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
			actionForward.setPath("../../WEB-INF/views/community/communityCommon/result2.jsp");
			return actionForward;
	}
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ReviewCommentsDTO reviewCommentsDTO = new ReviewCommentsDTO();
		reviewCommentsDTO.setCnum(Integer.parseInt(request.getParameter("cnum")));
		reviewCommentsDTO.setContents(request.getParameter("contents"));
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			result = reviewCommentsDAO.update(reviewCommentsDTO, con);
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
		actionForward.setPath("../../WEB-INF/views/community/communityCommon/result2.jsp");
		return actionForward;
	}
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		Connection con = null;
		int result = 0;
		try {
			int cnum = Integer.parseInt(request.getParameter("cnum"));
			con = DBConnector.getConnect();
			result = reviewCommentsDAO.delete(cnum, con);
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
		actionForward.setPath("../../WEB-INF/views/community/communityCommon/result2.jsp");
		return actionForward;
	}
}

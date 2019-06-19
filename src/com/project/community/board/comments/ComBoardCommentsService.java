package com.project.community.board.comments;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.community.comments.CommunityCommentsDTO;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ComBoardCommentsService implements Action{
	private ComBoardCommentsDAO comBoardCommentsDAO;
	public ComBoardCommentsService() {
		comBoardCommentsDAO = new ComBoardCommentsDAO();
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
			ar = comBoardCommentsDAO.selectList(searchRow, no, con);
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
		request.setAttribute("list", ar);
		actionForward.setCheck(true);
		actionForward.setPath("../../WEB-INF/views/community/communityCommon/list.jsp"); // 정해야됨;
		return actionForward;
	}
	// 사용안함;
	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ComBoardCommentsDTO comBoardCommentsDTO = new ComBoardCommentsDTO();
		comBoardCommentsDTO.setNo(Integer.parseInt(request.getParameter("no")));
		comBoardCommentsDTO.setWriter(request.getParameter("writer"));
		comBoardCommentsDTO.setContents(request.getParameter("contents"));
		int result = 0;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			result = comBoardCommentsDAO.insert(comBoardCommentsDTO, con);
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
		actionForward.setPath("../../common/result2.jsp"); // 뭔가 result2로 가는 경로;
		return actionForward;
	}
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		ComBoardCommentsDTO comBoardCommentsDTO = new ComBoardCommentsDTO();
		comBoardCommentsDTO.setCnum(Integer.parseInt(request.getParameter("cnum")));
		comBoardCommentsDTO.setContents(request.getParameter("contents"));
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			result = comBoardCommentsDAO.update(comBoardCommentsDTO, con);
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
		actionForward.setPath("../../common/result2.jsp"); // 뭔가 result2로 가는 경로;
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
			result = comBoardCommentsDAO.delete(cnum, con);
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
		actionForward.setPath(""); // 뭔가 result2로 가는 경로;
		return actionForward;
	}
}

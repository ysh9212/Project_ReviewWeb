package com.project.community.qna;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.board.BoardDTO;
import com.project.community.board.ComBoardDTO;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchPager;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class QnaService implements Action{
	private QnaDAO qnaDAO;
	public QnaService() {
		qnaDAO = new QnaDAO();
	}
	public ActionForward adminList(HttpServletRequest request, HttpServletResponse response) {
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
			List<BoardDTO> ar = qnaDAO.selectList(searchRow, con);
			totalCount = qnaDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "communityQna");
			actionForward.setCheck(true);
			actionForward.setPath("#");
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
			List<BoardDTO> ar = qnaDAO.selectList(searchRow, con);
			totalCount = qnaDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "communityQna");
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
			boardDTO = qnaDAO.selectOne(no, con);
			qnaDAO.updateHit(no, con);
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
			request.setAttribute("board", "communityQna");
			path = "../../WEB-INF/views/community/communityBoard/boardSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./board");
			path="../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		return actionForward;
	}
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		String path = "../../WEB-INF/views/community/communityBoard/boardWrite.jsp";
		if(method.equals("POST")) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle(request.getParameter("title"));
			qnaDTO.setWriter(request.getParameter("writer"));
			qnaDTO.setContents(request.getParameter("contents"));
			int result = 0;
			Connection con = null;
			try {
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				int no = qnaDAO.getNum();
				qnaDTO.setNo(no);
				result = qnaDAO.insert(qnaDTO, con);
				if(result<1) {
					throw new Exception();
				}
				con.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=0;
				try {
					con.rollback();
				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}finally {
				try {
					con.close();
					con.setAutoCommit(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(result>0) {
				check = false;
				path="./communityQna";
			}else {
				request.setAttribute("message", "Write Fail");
				request.setAttribute("path", "./communityQna");
				check = true;
				path="../../WEB-INF/views/common/result.jsp";
			}
		}// end of POST
		request.setAttribute("board", "communityQna");
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "../../WEB-INF/views/community/communityBoard/boardUpdate.jsp";
		String method = request.getMethod();
		if(method.equals("POST")) {
			Connection con = null;
			int result = 0;
			try {
				con = DBConnector.getConnect();
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setTitle(request.getParameter("title"));
				qnaDTO.setWriter(request.getParameter("writer"));
				qnaDTO.setContents(request.getParameter("contents"));
				qnaDTO.setNo(Integer.parseInt(request.getParameter("no")));
				result = qnaDAO.update(qnaDTO, con);
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
			check =false;
			path = "./communityQna";
			// end of post
		}else {
			int no = Integer.parseInt(request.getParameter("no"));
			Connection con = null;
			BoardDTO boardDTO = null;
			
			try {
				con = DBConnector.getConnect();
				boardDTO = qnaDAO.selectOne(no, con);
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
			} // end of finally
			request.setAttribute("dto", boardDTO);
			request.setAttribute("board", "communityQna");
		}
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "";
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			result = qnaDAO.delete(no, con);
			request.setAttribute("result", result);
			check = true;
			path = "../../WEB-INF/views/community/communityCommon/result2.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
}

package com.project.community.board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.board.BoardDAO;
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
	// 처음 게시글 나열
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
		ActionForward actionForward = new ActionForward();
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
			request.setAttribute("bdto", boardDTO);
			path = "../../WEB-INF/views/community/board/communityBoardSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./communityBoard");
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
		String path = "../../WEB-INF/views/community/board/communityBoardWrite.jsp";
		if(method.equals("POST")) {
			ComBoardDTO comBoardDTO = new ComBoardDTO();
			comBoardDTO.setTitle(request.getParameter("title"));
			comBoardDTO.setWriter(request.getParameter("writer"));
			comBoardDTO.setContents(request.getParameter("contents"));
			int result = 0;
			Connection con = null;
			
			try {
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				
				int no = comBoardDAO.getNum();
				comBoardDTO.setNo(no);
				result = comBoardDAO.insert(comBoardDTO, con);
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
				path="./communityBoard";
			}else {
				request.setAttribute("message", "Write Fail");
				request.setAttribute("path", "./communityBoard");
				check = true;
				path="../../WEB-INF/views/common/result.jsp";
			}
		}// end of POST
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "../../WEB-INF/views/community/board/communityBoardUpdate.jsp";
		String method = request.getMethod();
		if(method.equals("POST")) {
			Connection con = null;
			int result = 0;
			try {
				con = DBConnector.getConnect();
				ComBoardDTO comBoardDTO = new ComBoardDTO();
				comBoardDTO.setTitle(request.getParameter("title"));
				comBoardDTO.setWriter(request.getParameter("writer"));
				comBoardDTO.setContents(request.getParameter("contents"));
				comBoardDTO.setNo(Integer.parseInt(request.getParameter("no")));
				result = comBoardDAO.update(comBoardDTO, con);
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
			path = "./communityBoard";
			// end of post
		}else {
			int no = Integer.parseInt(request.getParameter("no"));
			Connection con = null;
			BoardDTO boardDTO = null;
			
			try {
				con = DBConnector.getConnect();
				boardDTO = comBoardDAO.selectOne(no, con);
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
			request.setAttribute("bdto", boardDTO);
		}
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path ="";
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			result = comBoardDAO.delete(no, con);
			request.setAttribute("result", result);
			check = true;
			path = "../../WEB-INF/views/common/result2.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}
}

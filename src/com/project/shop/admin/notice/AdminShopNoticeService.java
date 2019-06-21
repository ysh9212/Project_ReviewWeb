package com.project.shop.admin.notice;


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

public class AdminShopNoticeService implements Action{
	private AdminShopNoticeDAO adminShopNoticeDAO;
	public AdminShopNoticeService() {
		adminShopNoticeDAO = new AdminShopNoticeDAO();
	}
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		String path="../../../WEB-INF/views/admin/shop/board/boardWrite.jsp";
		if(method.equals("POST")) {
			AdminShopNoticeDTO adminShopNoticeDTO = new AdminShopNoticeDTO();
			adminShopNoticeDTO.setTitle(request.getParameter("title"));
			adminShopNoticeDTO.setWriter(request.getParameter("writer"));
			adminShopNoticeDTO.setContents(request.getParameter("contents"));
			int result = 0;
			Connection con = null;
			
			try {
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				
				int no = adminShopNoticeDAO.getNum();
				adminShopNoticeDTO.setNo(no);
				result = adminShopNoticeDAO.insert(adminShopNoticeDTO, con);
				
				if(result<1) {
					throw new Exception();
				}
				con.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = 0;
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(result>0) {
				check=false;
				path="./noticeList";
			}else {
				request.setAttribute("message", "Write Fail");
				request.setAttribute("path", "./noticeList");
				check = true;
				path = "../../../WEB-INF/views/common/result.jsp";
			}
		}//post끝
		actionForward.setCheck(check);
		actionForward.setPath(path);
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "../../../WEB-INF/views/admin/shop/board/boardUpdate.jsp";
		String method = request.getMethod();
		if(method.equals("POST")) {
			Connection con = null;
			int result = 0;
			
			try {
				con = DBConnector.getConnect();
				AdminShopNoticeDTO adminShopNoticeDTO = new AdminShopNoticeDTO();
				adminShopNoticeDTO.setTitle(request.getParameter("title"));
				adminShopNoticeDTO.setContents(request.getParameter("contents"));
				adminShopNoticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
				result = adminShopNoticeDAO.update(adminShopNoticeDTO, con);
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
			check = true;
			path = "./noticeList";
		}//post 끝
		else {
			int no = Integer.parseInt(request.getParameter("no"));
			Connection con = null;
			BoardDTO boardDTO = null;
			
			try {
				con = DBConnector.getConnect();
				boardDTO = adminShopNoticeDAO.selectOne(no, con);
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
			}//finally
			request.setAttribute("dto", boardDTO);
		}//get
		actionForward.setCheck(check);
		actionForward.setPath(path);
		
		return actionForward;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path="";
		Connection con = null;
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			result = adminShopNoticeDAO.delete(no, con);
			if(result>0) {
				check = false;
				path= "./noticeList";
			}
			else {
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./noticeList");
				check = true;
				path = "../../../WEB-INF/views/common/result.jsp";
			}
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
		actionForward.setCheck(check);
		actionForward.setPath(path);
				
		return actionForward;
	}
	
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int curPage = 1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		SearchMakePage s = new SearchMakePage(curPage, kind, search);
		
		//1. row
		SearchRow searchRow = s.makeRow();
		int totalCount = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			List<BoardDTO> ar = adminShopNoticeDAO.selectList(searchRow, con);
			//2.page
			totalCount = adminShopNoticeDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "notice");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/admin/shop/board/boardList.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../../index.do");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/common/result.jsp");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			boardDTO = adminShopNoticeDAO.selectOne(no, con);
			adminShopNoticeDAO.updateHit(no, con);
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
			request.setAttribute("board", "notice");
			path = "../../../WEB-INF/views/admin/shop/board/boardSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./noticeList");
			path="../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		return actionForward;
	}
}

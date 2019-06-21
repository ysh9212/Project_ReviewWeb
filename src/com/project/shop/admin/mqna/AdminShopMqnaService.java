package com.project.shop.admin.mqna;

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

public class AdminShopMqnaService implements Action{
	private AdminShopMqnaDAO adminShopMqnaDAO;
	public AdminShopMqnaService() {
		adminShopMqnaDAO = new AdminShopMqnaDAO();
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
			List<BoardDTO> ar = adminShopMqnaDAO.selectList(searchRow, con);
			//2.page
			totalCount = adminShopMqnaDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "mqna");
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
			boardDTO = adminShopMqnaDAO.selectOne(no, con);
			adminShopMqnaDAO.updateHit(no, con);
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
			request.setAttribute("board", "mqna");
			path = "../../../WEB-INF/views/admin/shop/board/boardSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./mqnaList");
			path="../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		return actionForward;	// TODO Auto-generated method stub
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		String path="../../../WEB-INF/views/admin/shop/board/boardWrite.jsp";
		if(method.equals("POST")) {
			AdminShopMqnaDTO adminShopMqnaDTO = new AdminShopMqnaDTO();
			adminShopMqnaDTO.setTitle(request.getParameter("title"));
			adminShopMqnaDTO.setWriter(request.getParameter("writer"));
			adminShopMqnaDTO.setContents(request.getParameter("contents"));
			int result = 0;
			Connection con = null;
			
			try {
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				
				int no = adminShopMqnaDAO.getNum();
				adminShopMqnaDTO.setNo(no);
				result = adminShopMqnaDAO.insert(adminShopMqnaDTO, con);
				
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
				path="./mqnaList";
			}else {
				request.setAttribute("message", "Write Fail");
				request.setAttribute("path", "./mqnaList");
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
				AdminShopMqnaDTO adminShopMqnaDTO = new AdminShopMqnaDTO();
				adminShopMqnaDTO.setTitle(request.getParameter("title"));
				adminShopMqnaDTO.setContents(request.getParameter("contents"));
				adminShopMqnaDTO.setNo(Integer.parseInt(request.getParameter("no")));
				result = adminShopMqnaDAO.update(adminShopMqnaDTO, con);
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
			path = "./mqnaList";
		}//post 끝
		else {
			int no = Integer.parseInt(request.getParameter("no"));
			Connection con = null;
			BoardDTO boardDTO = null;
			
			try {
				con = DBConnector.getConnect();
				boardDTO = adminShopMqnaDAO.selectOne(no, con);
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
			result = adminShopMqnaDAO.delete(no, con);
			if(result>0) {
				check = false;
				path= "./mqnaList";
			}
			else {
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./mqnaList");
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

}

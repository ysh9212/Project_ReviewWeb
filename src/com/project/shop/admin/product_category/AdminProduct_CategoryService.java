package com.project.shop.admin.product_category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.util.DBConnector;

public class AdminProduct_CategoryService implements Action{
	private AdminProduct_CategoryDAO adminProduct_CategoryDAO;
	public AdminProduct_CategoryService() {
		adminProduct_CategoryDAO = new AdminProduct_CategoryDAO();
	}
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			List<AdminProduct_CategoryDTO> ar =adminProduct_CategoryDAO.selectList(con);
			
			request.setAttribute("list", ar);
			request.setAttribute("board", "product_category");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/admin/shop/product/product_categoryList.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../admin.do");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/common/result.jsp");
		}
		
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		Connection con = null;
		AdminProduct_CategoryDTO adminProduct_CategoryDTO = null;
		
		try {
			con = DBConnector.getConnect();
			int product_category_no = Integer.parseInt(request.getParameter("product_category_no"));
			adminProduct_CategoryDTO = adminProduct_CategoryDAO.selectOne(product_category_no, con);
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
		if(adminProduct_CategoryDTO != null) {
			request.setAttribute("dto",adminProduct_CategoryDTO);
			request.setAttribute("board", "product_category");
			path="../../../WEB-INF/views/admin/shop/product/product_categorySelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./product_categoryList");
			path = "../../WEB-INF/views/common/result.jsp";
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
		String path = "";
		if(method.equals("POST")) {
			AdminProduct_CategoryDTO adminProduct_CategoryDTO = new AdminProduct_CategoryDTO();
			adminProduct_CategoryDTO.setPoduct_category_name(request.getParameter("product_category_name"));
			int result = 0;
			Connection con = null;
			
			try {
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				
				int product_category_no = adminProduct_CategoryDAO.getNum();
				adminProduct_CategoryDTO.setProduct_category_no(product_category_no);
				result = adminProduct_CategoryDAO.insert(adminProduct_CategoryDTO, con);
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
			}finally {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(result>0) {
				check = false;
				path = "./product_categoryList";
			}else {
				request.setAttribute("message", "Write Fail");
				request.setAttribute("path", "./product_categoryList");
				check = true;
				path = "../../WEB-INF/views/common/result.jsp";
			}
			
		}//post
		actionForward.setCheck(check);
		actionForward.setPath(path);
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "../../../WEB-INF/views/admin/shop/product/product_categoryUpdate.jsp";
		String method = request.getMethod();
		if(method.equals("POST")) {
			Connection con = null;
			
			try {
				con = DBConnector.getConnect();
				AdminProduct_CategoryDTO adminProduct_CategoryDTO = new AdminProduct_CategoryDTO();
				adminProduct_CategoryDTO.setPoduct_category_name(request.getParameter("product_category_name"));
				
				int result = adminProduct_CategoryDAO.update(adminProduct_CategoryDTO, con);
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
			path = "./product_categoryList";
		}//post
		else {
			Connection con = null;
			AdminProduct_CategoryDTO adminProduct_CategoryDTO = null;
			int product_category_no = Integer.parseInt(request.getParameter("product_category_no"));
			try {
				con = DBConnector.getConnect();
				adminProduct_CategoryDTO = adminProduct_CategoryDAO.selectOne(product_category_no, con);
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
			request.setAttribute("dto", adminProduct_CategoryDTO);
		}//get
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
			int product_category_no = Integer.parseInt(request.getParameter("product_category_no"));
			result = adminProduct_CategoryDAO.delete(product_category_no, con);
			if (result>0) {
				check = false;
				path = "./product_categoryList";
			}else {
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./product_categoryList");
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

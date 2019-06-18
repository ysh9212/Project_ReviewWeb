package com.project.shop.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchPager;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ProductService implements Action {
	private ProductDAO productDAO;
	public ProductService() {
		productDAO = new ProductDAO();
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
		
		//1.row
		SearchRow searchRow = s.makeRow();
		int totalCount = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			List<ProductDTO> ar = productDAO.selectList(searchRow, con);
			
			//2. page
			totalCount = productDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "product");
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/shop/shopList.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../index.do");
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/common/result.jsp");
		}
		
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		String path="";
		if(method.equals("POST")) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_color(request.getParameter("product_color"));
			productDTO.setProduct_size(request.getParameter("product_size"));
			productDTO.setProduct_stock(Integer.parseInt(request.getParameter("product_stock")));
			productDTO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
			int result = 0;
			Connection con = null;

			try {
				con=DBConnector.getConnect();
				con.setAutoCommit(false);
				
				int no = productDAO.getNum();
				productDTO.setProduct_no(no);
				result = productDAO.insert(productDTO, con);
				
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
				path="./shopList";
			}else {
				request.setAttribute("message", "Write Fail");
				request.setAttribute("path", "./shopList");
				check = true;
				path = "../../WEB-INF/views/common/result.jsp";
			}
			
			
		}//post 끝
		actionForward.setCheck(check);
		actionForward.setPath(path);
		
		return actionForward;
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

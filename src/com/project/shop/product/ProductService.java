package com.project.shop.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.shop.admin.product_upload.Product_UploadDAO;
import com.project.shop.admin.product_upload.Product_UploadDTO;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchPager;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class ProductService implements Action{
	private ProductDAO productDAO;
	private Product_UploadDAO product_UploadDAO;
	public ProductService() {
		productDAO = new ProductDAO();
		product_UploadDAO = new Product_UploadDAO();
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
		List<ProductDTO> ar = null;
		List<Product_UploadDTO> ar2 = null;
		Connection con = null;
		

		try {
			con = DBConnector.getConnect();
			ar = productDAO.selectList(searchRow, con);
			ar2 = product_UploadDAO.selectList(con);
			int totalCount = productDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("upload", ar2);
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/views/shop/shopList.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../index.do");
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/views/common/result.jsp");
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
		ProductDTO productDTO = null;
		Connection con = null;
		Product_UploadDTO product_UploadDTO = null;
		try {
			con = DBConnector.getConnect();
			int pno = Integer.parseInt(request.getParameter("pno"));
			productDTO = productDAO.selectOne(pno, con);
			product_UploadDTO = product_UploadDAO.selectOne(pno, con);
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
		if(productDTO != null) {
			request.setAttribute("dto", productDTO);
			request.setAttribute("upload", product_UploadDTO);
			path = "../../WEB-INF/views/shop/product/productSelect.jsp";
		}else {
			request.setAttribute("message", "No DATA");
			request.setAttribute("path", "./shopList");
			path = "../../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		
		return actionForward;
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

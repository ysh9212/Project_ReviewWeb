package com.project.shop.product_category;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.util.DBConnector;

public class Product_CategoryService implements Action{
	private Product_CategoryDAO product_CategoryDAO;
	public Product_CategoryService() {
		product_CategoryDAO = new Product_CategoryDAO();
	}

	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		Connection con = null;
		try {
			
			con= DBConnector.getConnect();
			List<Product_CategoryDTO> ar = product_CategoryDAO.selectList(con);
			request.setAttribute("list", ar);
			request.setAttribute("product_category", "product_category");
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/shop/product/product_categoryList.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
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

package com.project.shop.product_purchase;

import java.sql.*;

import javax.servlet.http.*;

import com.project.action.*;
import com.project.member.*;
import com.project.shop.admin.product_upload.*;
import com.project.shop.oder.*;
import com.project.shop.oder_product.*;
import com.project.shop.pay.*;
import com.project.shop.product.*;
import com.project.util.*;

public class ProductPurchaseService implements Action {
	private PayDAO payDAO;
	private Order_MainDAO order_MainDAO;
	private Order_ProductDAO order_ProductDAO;
	private ProductDAO productDAO;
	private Product_UploadDAO product_UploadDAO;
	
	public ProductPurchaseService() {
		payDAO = new PayDAO();
		order_MainDAO = new Order_MainDAO();
		order_ProductDAO = new Order_ProductDAO();
		productDAO = new ProductDAO();
		product_UploadDAO = new Product_UploadDAO();
		
	}

	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		int result = 0;
		Connection con = null;
		boolean check = true;
		MemberDTO memberDTO = (MemberDTO)(request.getSession().getAttribute("member"));
		request.setAttribute("memberDTO", memberDTO);
		String path = "../../WEB-INF/views/shop/product/productPurchase.jsp";
		if(method.equals("POST")) {
			try {
				con = DBConnector.getConnect();
				PayDTO payDTO = new PayDTO();
				int pno = payDAO.getNum();
				payDTO.setPno(pno);
				payDTO.setOpt(request.getParameter("opt"));
				payDTO.setPrice(Integer.parseInt(request.getParameter("price")));
				result = payDAO.insert(payDTO, con);
				
				if(result<1) {
					throw new Exception();
				}
				
				Order_MainDTO order_MainDTO = new Order_MainDTO();
				int ono = order_MainDAO.getNum();
				order_MainDTO.setOno(ono);
				order_MainDTO.setPno(payDTO.getPno());
				order_MainDTO.setId(request.getParameter("id"));
				order_MainDTO.setState("주문완료");
				result = order_MainDAO.insert(order_MainDTO, con);
				
				if(result<1) {
					throw new Exception();
				}
				
				Order_ProductDTO order_ProductDTO = new Order_ProductDTO();
				order_ProductDTO.setId(request.getParameter("id"));
				order_ProductDTO.setPno(Integer.parseInt(request.getParameter("pno")));
				order_ProductDTO.setCount(Integer.parseInt(request.getParameter("count")));
				order_ProductDTO.setPrice(Integer.parseInt(request.getParameter("price")));
				order_ProductDTO.setOno(order_MainDTO.getOno());
				
				result = order_ProductDAO.insert(order_ProductDTO, con);
				if(result <1) {
					throw new Exception();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			try {
				con = DBConnector.getConnect();
				ProductDTO productDTO = new ProductDTO();
				Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
				
				int pno = Integer.parseInt(request.getParameter("pno"));
				productDTO = productDAO.selectOne(pno, con);
				
				int num = Integer.parseInt(request.getParameter("num")); //주문하는 상품의 갯수와 가격 지정
				int price = num * productDTO.getPrice();
				
				if(productDTO!= null) {
					request.setAttribute("productDTO", productDTO);
					request.setAttribute("num", num);
					request.setAttribute("price", price);
				}
				
				product_UploadDTO = product_UploadDAO.selectOne(pno, con);
				
				if(product_UploadDTO != null) {
					request.setAttribute("upload", product_UploadDTO);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

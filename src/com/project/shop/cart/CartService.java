package com.project.shop.cart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.util.DBConnector;

public class CartService implements Action{
	private CartDAO cartDAO;
	public CartService() {
		cartDAO = new CartDAO();
	}
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			String id = request.getParameter("id");
			List<CartDTO> ar =  cartDAO.selectList(id, con);
			
			request.setAttribute("list", ar);
			actionForward.setCheck(true);
			actionForward.setPath("../../WEB-INF/views/shop/product/cartList.jsp");
			
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
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		CartDTO cartDTO = null;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			cartDTO = cartDAO.selectOne(no, con);
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
		if(cartDTO != null) {
			request.setAttribute("dto", cartDTO);
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		
		return actionForward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setPno(Integer.parseInt(request.getParameter("pno")));
		cartDTO.setId(request.getParameter("id"));
		cartDTO.setCount(Integer.parseInt(request.getParameter("count")));
		cartDTO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			result = cartDAO.insert(cartDTO, con);
			
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
			
		}
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			int no = Integer.parseInt(request.getParameter("no"));
			result = cartDAO.delete(no, con);
			if(result <1) {
				throw new Exception();
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
		return actionForward;
	}

}

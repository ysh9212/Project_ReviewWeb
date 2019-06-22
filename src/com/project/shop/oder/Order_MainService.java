package com.project.shop.oder;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.shop.pay.PayDAO;
import com.project.util.DBConnector;

public class Order_MainService implements Action{
	private Order_MainDAO order_MainDAO;
	private PayDAO payDAO;
	public Order_MainService() {
		order_MainDAO = new Order_MainDAO();
		payDAO = new PayDAO();
	}

	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		Connection con = null;
		Order_MainDTO order_MainDTO = null;
		try {
			con = DBConnector.getConnect();
			int ono = Integer.parseInt(request.getParameter("ono"));
			order_MainDTO = order_MainDAO.selectOne(ono, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(order_MainDTO != null) {
			request.setAttribute("order_main", order_MainDTO);
		}
		return actionForward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		Connection con = null;
		Order_MainDTO order_MainDTO = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			int ono = order_MainDAO.getNum();
			int pno = payDAO.getNum();
			order_MainDTO.setOno(ono);
			order_MainDTO.setPno(pno);
			order_MainDTO.setState(request.getParameter("state"));
			order_MainDTO.setPno(Integer.parseInt(request.getParameter("pno")));
			result = order_MainDAO.insert(order_MainDTO, con);
			if(result <1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		// TODO Auto-generated method stub
		return null;
	}
	
}

package com.project.shop.admin;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.util.DBConnector;

public class AdminService {
	//select
	private AdminDAO adminDAO;
	public AdminService() {
		adminDAO = new AdminDAO();
	}
	
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		AdminDTO adminDTO = null;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			adminDTO = adminDAO.login(adminDTO, con);
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
		} //finally
		String path="";
		if(adminDTO != null) {
			request.setAttribute("dto", adminDTO);
			request.setAttribute("admin", "admin");
			path="./main.jsp";
		}else {
			request.setAttribute("message", "잘못된 정보 입니다");
			request.setAttribute("path", "./adminLogin.jsp");
			path="../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		
		return actionForward;
	}
}

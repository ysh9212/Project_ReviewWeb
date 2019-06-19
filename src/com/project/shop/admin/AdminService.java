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
		boolean check = true;
		Connection con = null;
		String method = request.getMethod();
		String path="../WEB-INF/views/admin/adminLogin.jsp";
		if(method.equals("POST")) {
			AdminDTO adminDTO = new AdminDTO();

			adminDTO.setId(request.getParameter("id"));
			adminDTO.setPw(request.getParameter("pw"));
			try {
				con = DBConnector.getConnect();
				adminDTO = adminDAO.login(adminDTO, con);
				if(adminDTO.getId().equals("admin")) {
					request.getSession().setAttribute("session", adminDTO);
					check = false;
					path="../admin.do";
				}else {
					request.setAttribute("message", "잘못된 정보 입니다");
					request.setAttribute("path", "./adminLogin");
					path="../WEB-INF/views/common/result.jsp";
					check = true;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//finally
		}


		actionForward.setCheck(check);
		actionForward.setPath(path);

		return actionForward;
	}
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		request.getSession().invalidate();
		actionForward.setCheck(false);
		actionForward.setPath("../admin.do");
		
		return actionForward;
	}
}

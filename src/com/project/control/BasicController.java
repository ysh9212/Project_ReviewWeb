package com.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.member.MemberService;

/**
 * Servlet implementation class BasicController
 */
@WebServlet("/BasicController")
public class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionforward = new ActionForward();
		
		if(command.equals("/condiciones")) {
			actionforward.setCheck(true);
			actionforward.setPath("../WEB-INF/views/basic/condiciones.jsp");
		}else if(command.equals("/personalProtected")) {
			actionforward.setCheck(true);
			actionforward.setPath("../WEB-INF/views/basic/personalProtected.jsp");
		}else if(command.equals("/review")) {
			actionforward.setCheck(true);
			actionforward.setPath("../WEB-INF/views/basic/review.jsp");
		}
		
		if(actionforward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionforward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionforward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}

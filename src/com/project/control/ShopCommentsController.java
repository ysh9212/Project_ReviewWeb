package com.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.shop.notice.comments.CommentsService;

/**
 * Servlet implementation class ShopCommentsController
 */
@WebServlet("/ShopCommentsController")
public class ShopCommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentsService commentsService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCommentsController() {
        super();
        commentsService = new CommentsService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		System.out.println(command);
		ActionForward actionForward = null;
		if(command.equals("/commentsList")) {
			actionForward = commentsService.list(request, response);
		}else if(command.equals("/commentsWrite")) {
			actionForward = commentsService.insert(request, response);
		}else if(command.equals("/commentsUpdate")) {
			actionForward = commentsService.update(request, response);
		}else if(command.equals("/commentsDelete")) {
			actionForward = commentsService.delete(request, response);
		}
		
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
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

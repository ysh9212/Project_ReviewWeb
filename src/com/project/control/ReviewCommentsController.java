package com.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.review.CommentsService;

/**
 * Servlet implementation class ReviewCommentsController
 */
@WebServlet("/ReviewCommentsController")
public class ReviewCommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CommentsService commentsService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentsController() {
        super();
        // TODO Auto-generated constructor stub
        commentsService = new CommentsService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String command = request.getPathInfo();
	ActionForward actionForward =new  ActionForward();
	if (command.equals("/reviewselect")) {
		actionForward = commentsService.list(request, response);
	}
	if (actionForward.isCheck()) {
		RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
		view.forward(request, response);
	} else {
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

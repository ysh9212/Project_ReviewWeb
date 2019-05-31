package com.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.community.CommunityService;

/**
 * Servlet implementation class CommunityController
 */
@WebServlet("/CommunityController")
public class CommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		if(command.equals("/communityList")) {
			actionForward=communityService.list(request, response);
		}else if(command.equals("/communityNotice")) {
			actionForward=communityService.notice(request, response);
		}else if(command.equals("/communityBoard")) {
			actionForward=communityService.board(request, response);			
		}else if(command.equals("/communityReview")) {
			actionForward=communityService.review(request, response);			
		}else if(command.equals("/communityUsed")) {
			actionForward=communityService.used(request, response);
		}else if(command.equals("/communityQna")) {
			actionForward=communityService.qna(request, response);
		}else if(command.equals("/communityBug")) {
			actionForward=communityService.bug(request, response);
		}else {
			actionForward = new ActionForward(); // ?? 이거 왜함?
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

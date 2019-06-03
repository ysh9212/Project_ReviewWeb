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
        communityService = new CommunityService(); // 객체 생성을 안해서 service로 계속 연결을 못하고 있었음;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		// System.out.println("controller 도착");
		// System.out.println(command);
		// command = "/communityList" 로 오는거 확인;
		if(command.equals("/communityList")) {
			// System.out.println("if에 걸러짐"); 확인
			actionForward=communityService.allList(request, response);
		}else if(command.equals("/communityNotice")){
			actionForward=communityService.list(request, response);
		}else if(command.equals("/communityBoard")) {
			actionForward=communityService.list(request, response);
		}else if(command.equals("/communityReview")) {
			actionForward=communityService.list(request, response);
		}else if(command.equals("/communityUsed")) {
			actionForward=communityService.list(request, response);
		}else if(command.equals("/communityQna")) {
			actionForward=communityService.list(request, response);
		}else if(command.equals("/communityBug")) {
			actionForward=communityService.list(request, response);
		}else {
			actionForward = new ActionForward(); // ?? 이거 왜함? 초기화인가?
		}
		
		// service에서 해결한 뒤 다시 return받은 actionforward를 이용해 requesetdispatcher 를 세팅;
		// 그래야 path를 연결해서 출력 할 수 있는듯?
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

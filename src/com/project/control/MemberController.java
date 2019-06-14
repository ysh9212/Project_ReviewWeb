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
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        memberService = new MemberService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionforward = new ActionForward();
		
		if(command.equals("/memberCheck")) {
			actionforward.setCheck(true);
			actionforward.setPath("../WEB-INF/views/member/memberCheck.jsp");
		}else if(command.equals("/memberJoin")) {
			actionforward = memberService.insert(request, response);
		}else if(command.equals("/memberLogin")) {
			actionforward = memberService.select(request, response);
		}else if(command.equals("/memberLogout")) {
			actionforward = memberService.logout(request, response);
		}else if(command.equals("/idCheck")) {
			actionforward = memberService.idCheck(request, response);
		}else if(command.equals("/memberMypage")) {
			actionforward = memberService.mypage(request, response);
		}else if(command.equals("/memberSearchId")) {
			actionforward = memberService.searchId(request, response);
		}else if(command.equals("/memberSearchPw")) {
			actionforward = memberService.searchPw(request, response);
		}else if(command.equals("/nicknameCheck")) {
			actionforward = memberService.nicknameCheck(request, response);
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
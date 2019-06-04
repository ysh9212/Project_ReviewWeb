package com.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.shop.notice.ShopNoticeService;
import com.project.shop.qna.ShopQnaService;


/**
 * Servlet implementation class ShopController
 */
@WebServlet("/ShopController")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShopNoticeService shopNoticeService;
    private ShopQnaService shopQnaService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        shopNoticeService = new ShopNoticeService();
        shopQnaService = new ShopQnaService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = new ActionForward();
		if(command.equals("/shopList")) {
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/views/shop/shopList.jsp");
		}else if(command.equals("/notice/noticeList")){
			actionForward = shopNoticeService.list(request, response);
		}else if(command.equals("/notice/noticeSelect")) {
			actionForward = shopNoticeService.select(request, response);
		}else if(command.equals("/qna/qnaList")) {
			actionForward = shopQnaService.list(request, response);
		}else if(command.equals("/qna/qnaSelect")) {
			actionForward = shopQnaService.select(request, response);
		}else if(command.equals("/qna/qnaWrite")) {
			actionForward = shopQnaService.insert(request, response);
		}else if(command.equals("/qna/qnaUpdate")) {
			actionForward = shopQnaService.update(request, response);
		}else if(command.equals("/qna/qnaDelete")) {
			actionForward = shopQnaService.delete(request, response);
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

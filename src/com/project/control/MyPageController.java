package com.project.control;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.project.action.*;
import com.project.membermy.Reple.*;
import com.project.membermy.Write.*;
import com.project.membermy.bucket.*;
import com.project.membermy.page.*;
import com.project.membermy.pay.*;
import com.project.membermy.qna.*;
import com.project.membermy.scrap.*;
import com.project.membermy.shop.*;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/MyPageController")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyPageService mypageService;
	private MyScrapService myscrapService;
	private MyWriteService mywriteService;
	private MyRepleService myrepleService;
	private MyQnaService myqnaService;
	private MyBucketService mybucketService;
	private MyPayService mypayService;
	private MyShopService myshopService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
        mypageService = new MyPageService();
        myscrapService = new MyScrapService();
        mywriteService = new MyWriteService();
        myrepleService = new MyRepleService();
        myqnaService = new MyQnaService();
        mybucketService = new MyBucketService();
        mypayService = new MyPayService();
        myshopService = new MyShopService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getPathInfo();
		ActionForward actionforward = new ActionForward();
		
		if(command.equals("/memberMyPage")) {
			actionforward = mypageService.select(request, response);
		}else if(command.equals("/memberMyUpdate")) {
			actionforward = mypageService.update(request, response);
		}else if(command.equals("/memberMyPwUpdate")) {
			actionforward = mypageService.pwupdate(request, response);
		}else if(command.equals("/memberMyPay")) {
			actionforward = mypayService.select(request, response);
		}else if(command.equals("/memberMyQna")) {
			actionforward = myqnaService.select(request, response);
		}else if(command.equals("/memberMyReple")) {
			actionforward = myrepleService.select(request, response);
		}else if(command.equals("/memberMyScrap")) {
			actionforward = myscrapService.select(request, response);
		}else if(command.equals("/memberMyShop")) {
			actionforward = myshopService.select(request, response);
		}else if(command.equals("/memberMyWrite")) {
			actionforward = mywriteService.list(request, response);
		}else if(command.equals("/memberMyBucket")) {
			actionforward = mybucketService.select(request, response);
		}else if(command.equals("/memberMyDelete")) {
			actionforward = mypageService.delete(request, response);
		}else if(command.equals("/pwCheck")) {
			actionforward = mypageService.pwCheck(request, response);
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

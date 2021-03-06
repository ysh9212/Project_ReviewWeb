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
import com.project.community.board.ComBoardService;
import com.project.community.board.comments.ComBoardCommentsService;
import com.project.community.bug.BugService;
import com.project.community.bug.comments.BugCommentsService;
import com.project.community.notice.NoticeService;
import com.project.community.notice.comments.NoticeCommentsService;
import com.project.community.qna.QnaService;
import com.project.community.qna.comments.QnaCommentsService;
import com.project.community.review.ReviewService;
import com.project.community.review.comments.ReviewCommentsService;
import com.project.community.used.UsedService;
import com.project.community.used.comments.UsedCommentsService;
import com.project.shop.admin.AdminService;
import com.project.shop.admin.mqna.AdminShopMqnaService;
import com.project.shop.admin.notice.AdminShopNoticeService;
import com.project.shop.admin.product.ProductService;
import com.project.shop.admin.qna.AdminShopQnaService;

/**
 * Servlet implementation class ManageController
 */
@WebServlet("/ManageController")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminShopNoticeService adminShopNoticeService;
	private AdminShopQnaService adminShopQnaService;
	private AdminShopMqnaService adminShopMqnaService;
	private AdminService adminService;
    private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageController() {
        super();
        adminShopNoticeService = new AdminShopNoticeService();
        adminShopQnaService = new AdminShopQnaService();
        adminShopMqnaService = new AdminShopMqnaService();
        adminService = new AdminService();
        productService = new ProductService();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		int last=command.lastIndexOf("/");
		command = command.substring(last);
		ActionForward actionForward = new ActionForward();
		//notice
		if(command.equals("/noticeList")) {
			actionForward = adminShopNoticeService.list(request, response);
		}else if(command.equals("/noticeSelect")) {
			actionForward = adminShopNoticeService.select(request, response);
		}else if(command.equals("/noticeWrite")) {
			request.setAttribute("board", "notice");
			actionForward = adminShopNoticeService.insert(request, response);
		}else if(command.equals("/noticeUpdate")) {
			request.setAttribute("board", "notice");
			actionForward = adminShopNoticeService.update(request, response);
		}else if(command.equals("/noticeDelete")) {
			actionForward = adminShopNoticeService.delete(request, response);
		}//qna
		else if(command.equals("/qnaList")) {
			actionForward= adminShopQnaService.list(request, response);
		}else if(command.equals("/qnaWrite")) {
			request.setAttribute("board", "qna");
			actionForward= adminShopQnaService.insert(request, response);
		}else if(command.equals("/qnaSelect")) {
			actionForward= adminShopQnaService.select(request, response);
		}else if(command.equals("/qnaUpdate")) {
			request.setAttribute("board", "qna");
			actionForward= adminShopQnaService.update(request, response);
		}else if(command.equals("/qnaDelete")) {
			actionForward= adminShopQnaService.delete(request, response);
		}//mqna
		else if(command.equals("/mqnaList")) {
			actionForward= adminShopMqnaService.list(request, response);
		}else if(command.equals("/mqnaWrite")) {
			request.setAttribute("board", "mqna");
			actionForward= adminShopMqnaService.insert(request, response);
		}else if(command.equals("/mqnaSelect")) {
			actionForward= adminShopMqnaService.select(request, response);
		}else if(command.equals("/mqnaUpdate")) {
			request.setAttribute("board", "mqna");
			actionForward= adminShopMqnaService.update(request, response);
		}else if(command.equals("/mqnaDelete")) {
			actionForward= adminShopMqnaService.delete(request, response);
		}//product
		else if(command.equals("/productList")){
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/admin/shop/product/productList.jsp");
			actionForward = productService.list(request, response);
		}else if(command.equals("/productWrite")) {
			actionForward = productService.insert(request, response);
		}else if(command.equals("/productUpdate")) {
			actionForward = productService.update(request, response);
		}else if(command.equals("/productSelect")) {
			actionForward = productService.select(request, response);
		}else if(command.equals("/productDelete")) {
			actionForward = productService.delete(request, response);
		}
		//login
		else if(command.equals("/adminLogin")) {
			actionForward = adminService.select(request, response);
		}else if(command.equals("/adminLogout")) {
			// actionForward = adminService.logout(request, response);
		}else {
			actionForward = new ActionForward();
		}
		System.out.println(actionForward.isCheck());
		System.out.println(actionForward.getPath());
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

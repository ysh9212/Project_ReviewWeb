package com.project.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.shop.cart.CartService;
import com.project.shop.mqna.ShopMqnaService;
import com.project.shop.notice.ShopNoticeService;
import com.project.shop.product.ProductService;
import com.project.shop.product_purchase.ProductPurchaseService;
import com.project.shop.qna.ShopQnaService;


/**
 * Servlet implementation class ShopController
 */
@WebServlet("/ShopController")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShopNoticeService shopNoticeService;
    private ShopQnaService shopQnaService;
    private ShopMqnaService shopMqnaService;
    private ProductService productService;
    private CartService cartService;
    private ProductPurchaseService productPurchaseService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        shopNoticeService = new ShopNoticeService();
        shopQnaService = new ShopQnaService();
        shopMqnaService = new ShopMqnaService();
        productService = new ProductService();
        cartService = new CartService();
        productPurchaseService = new ProductPurchaseService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		int last = command.lastIndexOf("/");
		command = command.substring(last);
		ActionForward actionForward = new ActionForward();
		if(command.equals("/shopList")) {
			actionForward = productService.list(request, response);
		}else if(command.equals("/productSelect")) {
			actionForward = productService.select(request, response);
		}else if(command.equals("/productPurchase")) {
			actionForward = productPurchaseService.insert(request, response);
		}
		//notice
		else if(command.equals("/noticeList")){
			actionForward = shopNoticeService.list(request, response);
		}else if(command.equals("/noticeSelect")) {
			actionForward = shopNoticeService.select(request, response);
		}
		//qna
		else if(command.equals("/qnaList")) {
			actionForward = shopQnaService.list(request, response);
		}else if(command.equals("/qnaSelect")) {
			actionForward = shopQnaService.select(request, response);
		}else if(command.equals("/qnaWrite")) {
			actionForward = shopQnaService.insert(request, response);
		}else if(command.equals("/qnaUpdate")) {
			actionForward = shopQnaService.update(request, response);
		}else if(command.equals("/qnaDelete")) {
			actionForward = shopQnaService.delete(request, response);
		}
		//mqna
		else if(command.equals("/mqnaList")) {
			actionForward = shopMqnaService.list(request, response);
		}else if(command.equals("/mqnaSelect")) {
			actionForward = shopMqnaService.select(request, response);
		}
		//cart
		else if(command.equals("/cartInsert")) {
			actionForward = cartService.insert(request, response);
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

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
    //////// community /////////
	private CommunityService communityService;
	private NoticeService noticeService;
	private NoticeCommentsService noticeCommentsService;
	private ComBoardService comBoardService;
	private ComBoardCommentsService comBoardCommentsService;
	private ReviewService reviewService;
	private ReviewCommentsService reviewCommentsService;
	private UsedService usedService;
	private UsedCommentsService usedCommentsService;
	private QnaService qnaService;
	private QnaCommentsService qnaCommentsService;
	private BugService bugService;
	private BugCommentsService bugCommentsService;
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
        ////////community /////////
        communityService = new CommunityService();
        noticeService = new NoticeService();
        noticeCommentsService = new NoticeCommentsService();
        comBoardService = new ComBoardService();
        comBoardCommentsService = new ComBoardCommentsService();
        reviewService = new ReviewService();
        reviewCommentsService = new ReviewCommentsService();
        usedService = new UsedService();
        usedCommentsService = new UsedCommentsService();
        qnaService = new QnaService();
        qnaCommentsService = new QnaCommentsService();
        bugService = new BugService();
        bugCommentsService = new BugCommentsService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		System.out.println(command);
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
		/*
		}else if(command.equals("/adminLogout")) {
			actionForward = adminService.logout(request, response);
		*/
		///////////////////////////////// admin community 관련 주소;////////////////////////////////////////////
		// 공지사항;
		}else if(command.equals("/adminCommunityNotice")) {
			System.out.println("도착 확인");
			actionForward = noticeService.adminList(request, response);
		}else if(command.equals("/adminCommunityNoticeSelect")) {
			actionForward = noticeService.select(request, response);
		}else if(command.equals("/adminCommunityNoticeWrite")) {
			actionForward = noticeService.insert(request, response);
		}else if(command.equals("/adminCommunityNoticeUpdate")) {
			actionForward = noticeService.update(request, response);
		}else if(command.equals("/adminCommunityNoticeDelete")) {
			actionForward = noticeService.delete(request, response);
		// 자유게시판;
		}else if(command.equals("/adminCommunityBoard")) {
			actionForward = comBoardService.list(request, response);
		}else if(command.equals("/adminCommunityBoardSelect")) {
			actionForward = comBoardService.select(request, response);
		}else if(command.equals("/adminCommunityBoardWrite")){
			actionForward = comBoardService.insert(request, response);
		}else if(command.equals("/adminCommunityBoardUpdate")){
			actionForward = comBoardService.update(request, response);
		}else if(command.equals("/adminCommunityBoardDelete")){
			actionForward = comBoardService.delete(request, response);
		// 자유게시판 댓글;
		}else if(command.equals("/adminCommunityBoardCommentsList")) {
			actionForward = comBoardCommentsService.list(request, response);
		}else if(command.equals("/adminCommunityBoardCommentsInsert")){
			actionForward = comBoardCommentsService.insert(request, response);
		}else if(command.equals("/adminCommunityBoardCommentsUpdate")) {
			actionForward = comBoardCommentsService.update(request, response);
		}else if(command.equals("/adminCommunityBoardCommentsDelete")) {
				actionForward = comBoardCommentsService.delete(request, response);
		// 사용자 리뷰;
		}else if(command.equals("/adminCommunityReview")) {
			actionForward = reviewService.list(request, response);
		}else if(command.equals("/adminCommunityReviewSelect")) {
			actionForward = reviewService.select(request, response);
		}else if(command.equals("/adminCommunityReviewWrite")){
			actionForward = reviewService.insert(request, response);
		}else if(command.equals("/adminCommunityReviewUpdate")){
			actionForward = reviewService.update(request, response);
		}else if(command.equals("/adminCommunityReviewDelete")){
			actionForward = reviewService.delete(request, response);
		}else if(command.equals("/adminCommunityReviewCommentsList")){
			actionForward = reviewCommentsService.list(request, response);
		}else if(command.equals("/adminCommunityReviewCommentsInsert")){
			actionForward = reviewCommentsService.insert(request, response);
		}else if(command.equals("/adminCommunityReviewCommentsUpdate")){
			actionForward = reviewCommentsService.update(request, response);
		}else if(command.equals("/adminCommunityReviewCommentsDelete")){
			actionForward = reviewCommentsService.delete(request, response);
		// 중고 게시판;
		}else if(command.equals("/adminCommunityUsed")) {
			actionForward = usedService.list(request, response);
		}else if(command.equals("/adminCommunutyUsedSelect")) {
			actionForward = usedService.select(request, response);
		}else if(command.equals("/adminCommunityusedWrite")){
			actionForward = usedService.insert(request, response);
		}else if(command.equals("/adminCommunityusedUpdate")){
			actionForward = usedService.update(request, response);
		}else if(command.equals("/adminCommunityusedDelete")){
			actionForward = usedService.delete(request, response);
		// 중고게시판 댓글;
		}else if(command.equals("/adminReviewCommentsList")){
		}else if(command.equals("/adminReviewCommentsInsert")){
		}else if(command.equals("/adminReviewCommentsUpdate")){
		}else if(command.equals("/adminReviewCommentsDelete")){	
		// QnA;
		}else if(command.equals("/adminCommunityQna")) {
			actionForward = qnaService.list(request, response);
		}else if(command.equals("/adminCommunityQnaSelect")) {
			actionForward = qnaService.select(request, response);
		}else if(command.equals("/adminCommunityQnaWrite")){
			actionForward = qnaService.insert(request, response);
		}else if(command.equals("/adminCommunityQnaUpdate")){
			actionForward = qnaService.update(request, response);
		}else if(command.equals("/adminCommunityQnaDelete")){
			actionForward = qnaService.delete(request, response);
		}else if(command.equals("/adminCommunityQnaCommentsList")) {
			actionForward = qnaCommentsService.list(request, response);
		}else if(command.equals("/adminCommunityQnaCommentsInsert")){
			actionForward = qnaCommentsService.insert(request, response);
		}else if(command.equals("/adminCommunityQnaCommentsUpdate")) {
			actionForward = qnaCommentsService.update(request, response);
		}else if(command.equals("/adminCommunityQnaCommentsDelete")) {
			actionForward = qnaCommentsService.delete(request, response);
		// 버그 리포트;
		}else if(command.equals("/adminCommunityBug")) {
			actionForward = bugService.list(request, response);
		}else if(command.equals("/adminCommunityBugSelect")){
			actionForward = bugService.select(request, response);
		}else if(command.equals("/adminCommunityBugWrite")){
			actionForward = bugService.insert(request, response);
		}else if(command.equals("/adminCommunityBugUpdate")){
			actionForward = bugService.update(request, response);
		}else if(command.equals("/adminCommunityBugDelete")){
			actionForward = bugService.delete(request, response);
		}else if(command.equals("/adminCommunityBugRecommend")){
			actionForward = bugService.recommend(request, response);
		}else if(command.equals("/adminCommunityBugDecommend")){
			actionForward = bugService.decommend(request, response);
		// 버그 리포트 댓글;
		}else if(command.equals("/adminCommunityBugCommentsList")) {
			actionForward = bugCommentsService.list(request, response);
		}else if(command.equals("/adminCommunityBugCommentsInsert")){
			actionForward = bugCommentsService.insert(request, response);
		}else if(command.equals("/adminCommunityBugCommentsUpdate")) {
			actionForward = bugCommentsService.update(request, response);
		}else if(command.equals("/adminCommunityBugCommentsDelete")) {
			actionForward = bugCommentsService.delete(request, response);
		}else {
			actionForward = new ActionForward();
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

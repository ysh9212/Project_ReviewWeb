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

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class IndexAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
    public IndexAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		System.out.println(command);
		ActionForward actionForward = null;
		// 공지사항;
		if(command.equals("/admin/communityNotice")) {
			actionForward = noticeService.list(request, response);
		}else if(command.equals("/admin/communityNoticeSelect")) {
			actionForward = noticeService.select(request, response);
		}else if(command.equals("/admin/communityNoticeWrite")) {
			actionForward = noticeService.insert(request, response);
		}else if(command.equals("/admin/communityNoticeUpdate")) {
			actionForward = noticeService.update(request, response);
		}else if(command.equals("/admin/communityNoticeDelete")) {
			actionForward = noticeService.delete(request, response);
		//자유게시판;
		}else if(command.equals("/admin/communityBoard")) {
			actionForward = comBoardService.list(request, response);
		}else if(command.equals("/admin/communityBoardSelect")) {
			actionForward = comBoardService.select(request, response);
		}else if(command.equals("/admin/communityBoardWrite")){
			actionForward = comBoardService.insert(request, response);
		}else if(command.equals("/admin/communityBoardUpdate")){
			actionForward = comBoardService.update(request, response);
		}else if(command.equals("/admin/communityBoardDelete")){
			actionForward = comBoardService.delete(request, response);
		// 자유게시판 댓글;
		}else if(command.equals("/admin/communityBoardCommentsList")) {
			actionForward = comBoardCommentsService.list(request, response);
		}else if(command.equals("/admin/communityBoardCommentsInsert")){
			actionForward = comBoardCommentsService.insert(request, response);
		}else if(command.equals("/admin/communityBoardCommentsUpdate")) {
			actionForward = comBoardCommentsService.update(request, response);
		}else if(command.equals("/admin/communityBoardCommentsDelete")) {
				actionForward = comBoardCommentsService.delete(request, response);
		// 사용자 리뷰;
		}else if(command.equals("/admin/communityReview")) {
			actionForward = reviewService.list(request, response);
		}else if(command.equals("/admin/communityReviewSelect")) {
			actionForward = reviewService.select(request, response);
		}else if(command.equals("/admin/communityReviewWrite")){
			actionForward = reviewService.insert(request, response);
		}else if(command.equals("/admin/communityReviewUpdate")){
			actionForward = reviewService.update(request, response);
		}else if(command.equals("/admin/communityReviewDelete")){
			actionForward = reviewService.delete(request, response);
		}else if(command.equals("/admin/communityReviewCommentsList")){
			actionForward = reviewCommentsService.list(request, response);
		}else if(command.equals("/admin/communityReviewCommentsInsert")){
			actionForward = reviewCommentsService.insert(request, response);
		}else if(command.equals("/admin/communityReviewCommentsUpdate")){
			actionForward = reviewCommentsService.update(request, response);
		}else if(command.equals("/admin/communityReviewCommentsDelete")){
			actionForward = reviewCommentsService.delete(request, response);
		// 중고 게시판;
		}else if(command.equals("/admin/communityUsed")) {
			actionForward = usedService.list(request, response);
		}else if(command.equals("/admin/communutyUsedSelect")) {
			actionForward = usedService.select(request, response);
		}else if(command.equals("/admin/communityusedWrite")){
			actionForward = usedService.insert(request, response);
		}else if(command.equals("/admin/communityusedUpdate")){
			actionForward = usedService.update(request, response);
		}else if(command.equals("/admin/communityusedDelete")){
			actionForward = usedService.delete(request, response);
		// 중고게시판 댓글;
		}else if(command.equals("/admin/reviewCommentsList")){
		}else if(command.equals("/admin/reviewCommentsInsert")){
		}else if(command.equals("/admin/reviewCommentsUpdate")){
		}else if(command.equals("/admin/reviewCommentsDelete")){	
		// QnA;
		}else if(command.equals("/admin/communityQna")) {
			actionForward = qnaService.list(request, response);
		}else if(command.equals("/admin/communityQnaSelect")) {
			actionForward = qnaService.select(request, response);
		}else if(command.equals("/admin/communityQnaWrite")){
			actionForward = qnaService.insert(request, response);
		}else if(command.equals("/admin/communityQnaUpdate")){
			actionForward = qnaService.update(request, response);
		}else if(command.equals("/admin/communityQnaDelete")){
			actionForward = qnaService.delete(request, response);
		}else if(command.equals("/admin/communityQnaCommentsList")) {
			actionForward = qnaCommentsService.list(request, response);
		}else if(command.equals("/admin/communityQnaCommentsInsert")){
			actionForward = qnaCommentsService.insert(request, response);
		}else if(command.equals("/admin/communityQnaCommentsUpdate")) {
			actionForward = qnaCommentsService.update(request, response);
		}else if(command.equals("/admin/communityQnaCommentsDelete")) {
			actionForward = qnaCommentsService.delete(request, response);
		// 버그 리포트;
		}else if(command.equals("/admin/communityBug")) {
			actionForward = bugService.list(request, response);
		}else if(command.equals("/admin/communityBugSelect")){
			actionForward = bugService.select(request, response);
		}else if(command.equals("/admin/communityBugWrite")){
			actionForward = bugService.insert(request, response);
		}else if(command.equals("/admin/communityBugUpdate")){
			actionForward = bugService.update(request, response);
		}else if(command.equals("/admin/communityBugDelete")){
			actionForward = bugService.delete(request, response);
		}else if(command.equals("/admin/communityBugRecommend")){
			actionForward = bugService.recommend(request, response);
		}else if(command.equals("/admin/communityBugDecommend")){
			actionForward = bugService.decommend(request, response);
		// 버그 리포트 댓글;
		}else if(command.equals("/admin/communityBugCommentsList")) {
			actionForward = bugCommentsService.list(request, response);
		}else if(command.equals("/admin/communityBugCommentsInsert")){
			actionForward = bugCommentsService.insert(request, response);
		}else if(command.equals("/admin/communityBugCommentsUpdate")) {
			actionForward = bugCommentsService.update(request, response);
		}else if(command.equals("/admin/communityBugCommentsDelete")) {
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
    	// RequestDispatcher view = request.getRequestDispatcher("./WEB-INF/views/admin/main.jsp");
		// view.forward(request, response);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

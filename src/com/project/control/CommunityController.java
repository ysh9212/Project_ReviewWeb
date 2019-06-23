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
 * Servlet implementation class CommunityController
 */
@WebServlet("/CommunityController")
public class CommunityController extends HttpServlet {
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
    public CommunityController() {
        super();
        // TODO Auto-generated constructor stub
        communityService = new CommunityService(); // ��ü ������ ���ؼ� service�� ��� ������ ���ϰ� �־���;
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
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		// 대시보드;
		if(command.equals("/communityList")) {
			actionForward=communityService.list(request, response);
		// 공지사항;
		}else if(command.equals("/notice/communityNotice")){
			actionForward = noticeService.list(request, response);
		}else if(command.equals("/notice/communityNoticeSelect")) {
			actionForward = noticeService.select(request, response);
		// 사용안함;
		}else if(command.equals("/notice/communityNoticeWrite")) {
			actionForward = noticeService.insert(request, response);
		// 사용안함;
		}else if(command.equals("/notice/communityNoticeUpdate")) {
			actionForward = noticeService.update(request, response);
		// 사용안함;
		}else if(command.equals("/notice/communityNoticeDelete")) {
			actionForward = noticeService.delete(request, response);
		// 공지사항 댓글;
		}else if(command.equals("/communityComments/communityNoticeCommentsList")) {
			actionForward = noticeCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityNoticeCommentsInsert")){
			actionForward = noticeCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityNoticeCommentsUpdate")) {
			actionForward = noticeCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityNoticeCommentsDelete")) {
			actionForward = noticeCommentsService.delete(request, response);
		//자유게시판;
		}else if(command.equals("/board/communityBoard")) {
			actionForward = comBoardService.list(request, response);
		}else if(command.equals("/board/communityBoardSelect")) {
			actionForward = comBoardService.select(request, response);
		}else if(command.equals("/board/communityBoardWrite")){
			actionForward = comBoardService.insert(request, response);
		}else if(command.equals("/board/communityBoardUpdate")){
			actionForward = comBoardService.update(request, response);
		}else if(command.equals("/board/communityBoardDelete")){
			actionForward = comBoardService.delete(request, response);
		}else if(command.equals("/board/communityBoardRecommend")){
			actionForward = comBoardService.recommend(request, response);
		}else if(command.equals("/board/communityBoardDecommend")){
			actionForward = comBoardService.decommend(request, response);
		// 자유게시판 댓글;
		}else if(command.equals("/communityComments/communityBoardCommentsList")) {
			actionForward = comBoardCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityBoardCommentsInsert")){
			actionForward = comBoardCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityBoardCommentsUpdate")) {
			actionForward = comBoardCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityBoardCommentsDelete")) {
			actionForward = comBoardCommentsService.delete(request, response);
		// 사용자 리뷰;
		}else if(command.equals("/review/communityReview")) {
			actionForward = reviewService.list(request, response);
		}else if(command.equals("/review/communityReviewSelect")) {
			actionForward = reviewService.select(request, response);
		}else if(command.equals("/review/communityReviewWrite")){
			actionForward = reviewService.insert(request, response);
		}else if(command.equals("/review/communityReviewUpdate")){
			actionForward = reviewService.update(request, response);
		}else if(command.equals("/review/communityReviewDelete")){
			actionForward = reviewService.delete(request, response);
		}else if(command.equals("/review/communityReviewRecommend")){
			actionForward = reviewService.recommend(request, response);
		}else if(command.equals("/review/communityReviewDecommend")){
			actionForward = reviewService.decommend(request, response);
		// 사용자 리뷰 댓글;
		}else if(command.equals("/communityComments/communityReviewCommentsList")){
			actionForward = reviewCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityReviewCommentsInsert")){
			actionForward = reviewCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityReviewCommentsUpdate")){
			actionForward = reviewCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityReviewCommentsDelete")){
			actionForward = reviewCommentsService.delete(request, response);
		
		// 중고 게시판;
		}else if(command.equals("/used/communityUsed")) {
			actionForward = usedService.list(request, response);
		}else if(command.equals("/used/communutyUsedSelect")) {
			actionForward = usedService.select(request, response);
		}else if(command.equals("/used/communityusedWrite")){
			actionForward = usedService.insert(request, response);
		}else if(command.equals("/used/communityusedUpdate")){
			actionForward = usedService.update(request, response);
		}else if(command.equals("/used/communityusedDelete")){
			actionForward = usedService.delete(request, response);
		// 중고게시판 댓글;
		}else if(command.equals("/communityComments/reviewCommentsList")){
		}else if(command.equals("/communityComments/reviewCommentsInsert")){
		}else if(command.equals("/communityComments/reviewCommentsUpdate")){
		}else if(command.equals("/communityComments/reviewCommentsDelete")){	
		
		// QnA;
		}else if(command.equals("/qna/communityQna")) {
			actionForward = qnaService.list(request, response);
		}else if(command.equals("/qna/communityQnaSelect")) {
			actionForward = qnaService.select(request, response);
		}else if(command.equals("/qna/communityQnaWrite")){
			actionForward = qnaService.insert(request, response);
		}else if(command.equals("/qna/communityQnaUpdate")){
			actionForward = qnaService.update(request, response);
		}else if(command.equals("/qna/communityQnaDelete")){
			actionForward = qnaService.delete(request, response);
		// QnA 댓글;
		}else if(command.equals("/communityComments/communityQnaCommentsList")) {
			actionForward = qnaCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityQnaCommentsInsert")){
			actionForward = qnaCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityQnaCommentsUpdate")) {
			actionForward = qnaCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityQnaCommentsDelete")) {
			actionForward = qnaCommentsService.delete(request, response);
		// 버그 리포트;
		}else if(command.equals("/bug/communityBug")) {
			actionForward = bugService.list(request, response);
		}else if(command.equals("/bug/communityBugSelect")){
			actionForward = bugService.select(request, response);
		}else if(command.equals("/bug/communityBugRecommend")){
			actionForward = bugService.recommend(request, response);
		}else if(command.equals("/bug/communityBugDecommend")){
			actionForward = bugService.decommend(request, response);
		// 버그 리포트 댓글;
		}else if(command.equals("/communityComments/communityBugCommentsList")) {
			actionForward = bugCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityBugCommentsInsert")){
			actionForward = bugCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityBugCommentsUpdate")) {
			actionForward = bugCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityBugCommentsDelete")) {
			actionForward = bugCommentsService.delete(request, response);
			// 사용안함;
		}else if(command.equals("/bug/communityBugWrite")){
			actionForward = bugService.insert(request, response);
			// 사용안함;
		}else if(command.equals("/bug/communityBugUpdate")){
			actionForward = bugService.update(request, response);
			// 사용안함;
		}else if(command.equals("/bug/communityBugDelete")){
			actionForward = bugService.delete(request, response);
		}else {
			actionForward = new ActionForward(); // ?? �̰� ����? �ʱ�ȭ�ΰ�?
		}
		// service���� �ذ��� �� �ٽ� return���� actionforward�� �̿��� requesetdispatcher �� ����;
		// �׷��� path�� �����ؼ� ��� �� �� �ִµ�?
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

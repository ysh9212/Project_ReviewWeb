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
import com.project.event.comments.EventCommentsService;
import com.project.news.comments.NewsCommentsService;

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
	private com.project.review.comments.ReviewCommentsService reviewCommentsService2;
	private NewsCommentsService newsCommentsService;
	private EventCommentsService eventCommentsService;

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
		reviewCommentsService2 =new com.project.review.comments.ReviewCommentsService();
		newsCommentsService = new NewsCommentsService();
		eventCommentsService= new EventCommentsService();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		System.out.println(command);
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
			///////////////////////////////// 관리자 모드 사용 컨트롤러;///////////////////////////////////////////
			// 공지사항;
		}else if(command.equals("/adminCommunityNotice")) {
			actionForward = noticeService.list(request, response);
		}else if(command.equals("/community/adminCommunityNoticeSelect")) {
			actionForward = noticeService.select(request, response);
		}else if(command.equals("/communityAdmin/communityNoticeWrite")) {
			actionForward = noticeService.insert(request, response);
		}else if(command.equals("/communityAdmin/communityNoticeUpdate")) {
			actionForward = noticeService.update(request, response);
		}else if(command.equals("/communityAdmin/communityNoticeDelete")) {
			actionForward = noticeService.delete(request, response);
			// 공지사항 댓글;
		}else if(command.equals("/adminCommunityNoticeCommentsList")) {
			actionForward = noticeCommentsService.list(request, response);
		}else if(command.equals("/adminCommunityNoticeCommentsInsert")){
			actionForward = noticeCommentsService.insert(request, response);
		}else if(command.equals("/adminCommunityNoticeCommentsUpdate")) {
			actionForward = noticeCommentsService.update(request, response);
		}else if(command.equals("/adminCommunityNoticeCommentsDelete")) {
			actionForward = noticeCommentsService.delete(request, response);
			//	자유게시판;
		}else if(command.equals("/adminCommunityBoardList")) {
			actionForward = comBoardService.adminList(request, response);
		}else if(command.equals("/adminCommunityBoardSelect")) {
			actionForward = comBoardService.adminSelect(request, response);
		}else if(command.equals("/adminCommunityBoardWrite")){
			actionForward = comBoardService.adminInsert(request, response);
		}else if(command.equals("/adminCommunityBoardUpdate")){
			actionForward = comBoardService.adminUpdate(request, response);
		}else if(command.equals("/adminCommunityBoardDelete")){
			actionForward = comBoardService.adminDelete(request, response);
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
			///////////////////////////////// 관리자 모드 사용 컨트롤러 끝;///////////////////////////////////////////
			//----------------------------관리자 작성메뉴------
			//관리자리뷰 댓글;
		}else if(command.equals("/communityComments/communityReview2CommentsList")) {
			actionForward = reviewCommentsService2.list(request, response);
		}else if(command.equals("/communityComments/communityReview2CommentsInsert")){
			actionForward = reviewCommentsService2.insert(request, response);
		}else if(command.equals("/communityComments/communityReview2CommentsUpdate")) {
			actionForward = reviewCommentsService2.update(request, response);
		}else if(command.equals("/communityComments/communityReview2CommentsDelete")) {
			actionForward = reviewCommentsService2.delete(request, response);
			//관리자 뉴스 댓글;
		}else if(command.equals("/communityComments/communityNewsCommentsList")) {
			actionForward = newsCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityNewsCommentsInsert")){
			actionForward = newsCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityNewsCommentsUpdate")) {
			actionForward = newsCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityNewsCommentsDelete")) {
			actionForward = newsCommentsService.delete(request, response);
			//이벤트 댓글
		}else if(command.equals("/communityComments/communityEventCommentsList")) {
			actionForward = eventCommentsService.list(request, response);
		}else if(command.equals("/communityComments/communityEventCommentsInsert")){
			actionForward = eventCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/communityEventCommentsUpdate")) {
			actionForward = eventCommentsService.update(request, response);
		}else if(command.equals("/communityComments/communityEventCommentsDelete")) {
			actionForward = eventCommentsService.delete(request, response);

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

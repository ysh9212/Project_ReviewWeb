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
import com.project.community.notice.NoticeService;
import com.project.community.qna.QnaService;
import com.project.community.review.ReviewService;
import com.project.community.used.UsedService;

/**
 * Servlet implementation class CommunityController
 */
@WebServlet("/CommunityController")
public class CommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityService;
	private NoticeService noticeService;
	private ComBoardService comBoardService;
	private ComBoardCommentsService comBoardCommentsService;
	private ReviewService reviewService;
	private UsedService usedService;
	private QnaService qnaService;
	private BugService bugService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityController() {
        super();
        // TODO Auto-generated constructor stub
        communityService = new CommunityService(); // 객체 생성을 안해서 service로 계속 연결을 못하고 있었음;
        noticeService = new NoticeService();
        comBoardService = new ComBoardService();
        comBoardCommentsService = new ComBoardCommentsService();
        reviewService = new ReviewService();
        usedService = new UsedService();
        qnaService = new QnaService();
        bugService = new BugService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = null;
		// 대시보드
		if(command.equals("/communityList")) {
			actionForward=communityService.list(request, response);
		
		// 공지사항
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
		
		// 자유게시판
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
		// 자유게시판 댓글	
		}else if(command.equals("/communityComments/comBoardCommentsList")) {
			actionForward = comBoardCommentsService.list(request, response);
		}else if(command.equals("/communityComments/comBoardCommentsInsert")){
			actionForward = comBoardCommentsService.insert(request, response);
		}else if(command.equals("/communityComments/comBoardCommentsUpdate")) {
			actionForward = comBoardCommentsService.update(request, response);
		}else if(command.equals("/communityComments/comBoardCommentsDelete")) {
			actionForward = comBoardCommentsService.delete(request, response);
		// 사용자리뷰
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
		
		// 중고나라
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
		
		// QnA
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
			
		// 버그리포트
		}else if(command.equals("/bug/communityBug")) {
			actionForward = bugService.list(request, response);
		}else if(command.equals("/bug/communityBugSelect")){
			actionForward = bugService.select(request, response);
		
		
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

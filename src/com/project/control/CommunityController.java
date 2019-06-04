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
import com.project.community.board.BoardService;
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
	private BoardService boardService;
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
        communityService = new CommunityService(); // ��ü ������ ���ؼ� service�� ��� ������ ���ϰ� �־���;
        noticeService = new NoticeService();
        boardService = new BoardService();
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
		// System.out.println("controller ����");
		// System.out.println(command);
		// command = "/communityList" �� ���°� Ȯ��;
		if(command.equals("/communityList")) {
			// System.out.println("if�� �ɷ���"); Ȯ��
			actionForward=communityService.list(request, response);
		}else if(command.equals("/notice/communityNotice")){
			actionForward = noticeService.list(request, response);
		}else if(command.equals("/board/communityBoard")) {
			actionForward = boardService.list(request, response);
		}else if(command.equals("/review/communityReview")) {
			actionForward = reviewService.list(request, response);
		}else if(command.equals("/used/communityUsed")) {
			actionForward = usedService.list(request, response);
		}else if(command.equals("/qna/communityQna")) {
			actionForward = qnaService.list(request, response);
		}else if(command.equals("/bug/communityBug")) {
			actionForward = bugService.list(request, response);
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

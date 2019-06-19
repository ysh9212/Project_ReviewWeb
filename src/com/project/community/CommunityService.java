package com.project.community;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.ActionForward;
import com.project.board.BoardDTO;
import com.project.community.board.ComBoardDAO;
import com.project.community.bug.BugDAO;
import com.project.community.notice.NoticeDAO;
import com.project.community.qna.QnaDAO;
import com.project.community.review.ReviewDAO;
import com.project.community.used.UsedDAO;
import com.project.shopPage.SearchRow;
import com.project.util.DBConnector;

public class CommunityService {
	private NoticeDAO noticeDAO;
	private ComBoardDAO comBoardDAO;
	private ReviewDAO reviewDAO;
	private UsedDAO usedDAO;
	private QnaDAO qnaDAO;
	private BugDAO bugDAO;
	public CommunityService() {
		noticeDAO = new NoticeDAO();
		comBoardDAO = new ComBoardDAO();
		reviewDAO = new ReviewDAO();
		usedDAO = new UsedDAO();
		qnaDAO = new QnaDAO();
		bugDAO = new BugDAO();
		
	}
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		SearchRow searchRow = new SearchRow();
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			List<BoardDTO> ar = noticeDAO.selectList(searchRow, con);
			List<BoardDTO> bAr = comBoardDAO.selectList(searchRow, con);
			List<BoardDTO> rAr = reviewDAO.selectList(searchRow, con);
			List<BoardDTO> bugAr = bugDAO.selectList(searchRow, con);
			List<BoardDTO> uAr = usedDAO.selectList(searchRow, con);
			
			request.setAttribute("nlist", ar);
			request.setAttribute("nboard", "��������");

			request.setAttribute("blist", bAr);
			request.setAttribute("bboard", "�����Խ���");

			request.setAttribute("rlist", rAr);
			request.setAttribute("rboard", "��������");

			request.setAttribute("buglist", bugAr);
			request.setAttribute("bugboard", "���װԽ���");

			request.setAttribute("ulist", uAr);
			request.setAttribute("uboard", "�߰��ǰ");

			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/views/community/communityList.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			actionForward.setCheck(true);
			actionForward.setPath("../WEB-INF/views/community/communityList.jsp");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return actionForward;
	}

}

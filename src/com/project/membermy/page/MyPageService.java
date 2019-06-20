package com.project.membermy.page;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.member.MemberDAO;
import com.project.member.MemberDTO;
import com.project.util.DBConnector;

public class MyPageService implements Action{
	private MyPageDAO mypageDAO;
	private MemberDAO memberDAO;
	
	public MyPageService() {
		mypageDAO = new MyPageDAO();
		memberDAO = new MemberDAO();
	}
	
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ActionForward pwCheck(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();

		String pw = request.getParameter("cur_pw");
		
		int check = 0;
		Connection con;
	
		try {
			con = DBConnector.getConnect();
			check = mypageDAO.pwCheck(pw, con);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", check);
		System.out.println(check);
		actionforward.setCheck(true);
		actionforward.setPath("../WEB-INF/views/common/result2.jsp");
		
		return actionforward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		MemberDTO memberDTO = new MemberDTO();
		Connection con = null;
		
		
		try {
			con = DBConnector.getConnect();
			memberDTO = (MemberDTO)(request.getSession().getAttribute("member"));
			memberDTO = mypageDAO.memberMyPage(memberDTO, con);
			if(memberDTO != null) {
				request.setAttribute("memberDTO", memberDTO);
				
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		actionforward.setCheck(true);
		actionforward.setPath("../WEB-INF/views/memberMy/memberMyPage.jsp");
		return actionforward;
	}

	public ActionForward nicknameCheck(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String nickname = request.getParameter("nickname");
		int check = 0;
		Connection con;
		
		try {
			con = DBConnector.getConnect();
			check = memberDAO.nicknameCheck(nickname, con);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", check);
		actionforward.setCheck(true);
		actionforward.setPath("../WEB-INF/views/common/result2.jsp");
		return actionforward;
	}
	
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String method = request.getMethod();
		Connection con = null;
		int result = 0;
		String path = "../WEB-INF/views/memberMy/memberMyUpdate.jsp";
		MemberDTO memberDTO = new MemberDTO();			
		
		if(method.equals("POST")) {
		
		try {
			con = DBConnector.getConnect();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setName(request.getParameter("name"));
			memberDTO.setNickname(request.getParameter("nickname"));
			memberDTO.setPhone(request.getParameter("phone"));
			memberDTO.setAddress(request.getParameter("address"));
			memberDTO.setEmail(request.getParameter("email"));
			
			result = mypageDAO.memberMyUpdate(memberDTO, con);
			if(result>0) {
				request.setAttribute("message", "정상적으로 수정했습니다.");
				request.setAttribute("path", "./memberMyPage");
				path = "../WEB-INF/views/common/result.jsp";
				}else {
					
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			try {
				con = DBConnector.getConnect();
				memberDTO = (MemberDTO)(request.getSession().getAttribute("member"));
				request.setAttribute("memberDTO", memberDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		actionforward.setCheck(true);
		actionforward.setPath(path);
		return actionforward;
	}
	
	public ActionForward pwupdate(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String method = request.getMethod();
		Connection con = null;
		int result = 0;
		String path = "../WEB-INF/views/memberMy/memberMyPwUpdate.jsp";
		MemberDTO memberDTO = new MemberDTO();			
		
		if(method.equals("POST")) {
		
		try {
			con = DBConnector.getConnect();
			
			memberDTO.setPw(request.getParameter("pswd1"));
			memberDTO.setId(request.getParameter("id"));
			
			result = mypageDAO.memberMyPwUpdate(memberDTO, con);
			System.out.println(result);
			if(result>0) {
				request.setAttribute("message", "정상적으로 패스워드를 수정했습니다.");
				request.setAttribute("path", "./memberMyPage");
				path = "../WEB-INF/views/common/result.jsp";
				}else {
					
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			try {
				con = DBConnector.getConnect();
				memberDTO = (MemberDTO)(request.getSession().getAttribute("member"));
				request.setAttribute("memberDTO", memberDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		actionforward.setCheck(true);
		actionforward.setPath(path);
		return actionforward;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		MemberDTO memberDTO = new MemberDTO();
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			memberDTO = (MemberDTO)(request.getSession().getAttribute("member"));
			
			
			String id = memberDTO.getId();
			
			result = memberDAO.memberDelete(id, con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				request.getSession().invalidate();
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		request.setAttribute("result", result);
		request.setAttribute("message", "정상적으로 탈퇴했습니다.");
		request.setAttribute("path", "../index.do");
		
		actionforward.setCheck(true);
		actionforward.setPath("../WEB-INF/views/common/result.jsp");
		
		return actionforward;
	}

}

package com.project.member;

import java.sql.Connection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.util.DBConnector;

public class MemberService implements Action {
	private MemberDAO memberdao;

	
	public MemberService() {
		memberdao = new MemberDAO();

	}
	
	public ActionForward idCheck(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String id = request.getParameter("id");
		int check = 0;
		Connection con;
		
		try {
			con = DBConnector.getConnect();
			check = memberdao.idCheck(id, con);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", check);
		actionforward.setCheck(true);
		actionforward.setPath("../WEB-INF/views/common/result.jsp");
		return actionforward;
	}
	
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		request.getSession().invalidate();
		actionforward.setCheck(false);
		actionforward.setPath("../index.do");
		
		return actionforward;
	}
	
	public ActionForward mypage(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		
		String path = "../WEB-INF/views/member/memberMypage.jsp";
		
		return actionforward;
	}
	
	public ActionForward search(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		
		String path = "../WEB-INF/views/member/memberSearch.jsp";
		
		return actionforward;
	}
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		
		String method = request.getMethod();
		boolean check = true;
		String path = "../WEB-INF/views/member/memberLogin.jsp";
		
		if(method.equals("POST")) {
			MemberDAO memberDAO = new MemberDAO();
			MemberDTO memberDTO = new MemberDTO();
			
			String checkbox = request.getParameter("check");
			System.out.println(request.getParameter("id"));
			if(checkbox!=null) {
				Cookie c = new Cookie("check", request.getParameter("id"));
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("check",null);
				response.addCookie(c);
			}
			
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			
			try {
				memberDTO = memberDAO.memberLogin(memberDTO);
				System.out.println(memberDTO);
				if(memberDTO != null) {
					request.getSession().setAttribute("member", memberDTO);
					check = false;
					path = "../index.do";
				}else {
					request.setAttribute("message", "로그인 실패");
					request.setAttribute("path", "./memberLogin");
					check = true;
					path = "../WEB-INF/views/common/result.jsp";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		actionforward.setCheck(check);
		actionforward.setPath(path);
		
		return actionforward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		
		String method = request.getMethod();
		System.out.println(method);
		boolean check = true;
		String path="../WEB-INF/views/member/memberJoin.jsp";
		if(method.equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setId("id");
		}
		actionforward.setCheck(check);
		actionforward.setPath(path);
		
		return actionforward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

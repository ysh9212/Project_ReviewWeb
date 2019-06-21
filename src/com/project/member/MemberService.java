package com.project.member;


import java.sql.Connection;
import java.sql.Date;
import java.util.Properties;
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.servlet.http.HttpSession;
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
		actionforward.setPath("../WEB-INF/views/common/result2.jsp");
		
		return actionforward;
	}
	
	
	
	public ActionForward nicknameCheck(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		String nickname = request.getParameter("nickname");
		int check = 0;
		Connection con;
		
		try {
			con = DBConnector.getConnect();
			check = memberdao.nicknameCheck(nickname, con);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", check);
		actionforward.setCheck(true);

		actionforward.setPath("../WEB-INF/views/common/result2.jsp");

		return actionforward;
	}
	
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();

		request.getSession().invalidate();  // 세션을 종료

		actionforward.setCheck(false);
		actionforward.setPath("../index.do");
		
		return actionforward;
	}
	
	
	public ActionForward searchId(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		
		String method = request.getMethod();
		boolean check = true;
		String path = "../WEB-INF/views/member/memberSearchId.jsp";
		
		
		Connection con;
		if(method.equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setName(request.getParameter("name"));
			memberDTO.setEmail(request.getParameter("email"));
			
			try {
				con = DBConnector.getConnect();
				memberDTO = memberdao.memberSearchId(memberDTO, con);
				
				if(memberDTO != null) {
					 request.setAttribute("idsearch", memberDTO);
					 check = true;
					 path = "../WEB-INF/views/common/idSearch.jsp";
				}else {
					request.setAttribute("message", "실패");
					request.setAttribute("path", "./memberSearchId");
					check = true;
					path = "../WEB-INF/views/common/result.jsp";
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		actionforward.setCheck(check);
		actionforward.setPath(path);
		
		return actionforward;
	}
	
	public ActionForward searchPw(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionforward = new ActionForward();
		
		String method = request.getMethod();
		boolean check = true;
		String path = "../WEB-INF/views/member/memberSearchPw.jsp";
		
		Connection con;
		if(method.equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setName(request.getParameter("name"));
			memberDTO.setEmail(request.getParameter("email"));
			
			
			try {
				con = DBConnector.getConnect();
				memberDTO = memberdao.memberSearchPw(memberDTO, con);
				
				if(memberDTO != null) {
					
					
					String host = "smtp.naver.com";
					String user = "kws332";
					String password = "wonsikwonsik";
					
					String to_email = memberDTO.getEmail();
					
					Properties props = new Properties();
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.port",  465);
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.ssl.enable", "true");
					
					StringBuffer temp = new StringBuffer();
					Random rnd = new Random();
					
					for(int i=0; i<10; i++) {
						int rIndex = rnd.nextInt(3);
						switch (rIndex) {
						case 0:
							temp.append((char)((int)(rnd.nextInt(26))+97));
							break;
						case 1:
							temp.append((char)((int)(rnd.nextInt(26))+65));
							break;
						case 2:
							temp.append((rnd.nextInt(10)));
							break;
						}
					}
					
					String AuthenticationKey = temp.toString();
				
					/*
					javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						
						protected javax.mail.PasswordAuthentication getPasswordAuthentiation() {
							return new javax.mail.PasswordAuthentication(user, password);
						}
					});
					
					try {
						MimeMessage msg = new MimeMessage(session);
						msg.setFrom(new InternetAddress(user, "Under KG"));
						msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
						
						msg.setSubject("안녕하세요 Under KG 인증 메일입니다.");
						
						msg.setText("인증 번호는 :"+temp);
						
						Transport.send(msg);
						System.out.println("이메일 전송");
					}catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
					HttpSession saveKey = request.getSession();
					*/
					
					request.setAttribute("message", "이메일로 패스워드를 전송했습니다. 확인 후 로그인!!!");
					request.setAttribute("path", "./memberLogin");
					check = true;
					path = "../WEB-INF/views/common/result.jsp";
				}else {
					request.setAttribute("message", "실패");
					request.setAttribute("path", "./memberSearchPw");
					check = true;
					path = "../WEB-INF/views/common/result.jsp";
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		actionforward.setCheck(check);
		actionforward.setPath(path);
		
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

		boolean check = true;
		String path="../WEB-INF/views/member/memberJoin.jsp";
		if(method.equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			
			try {
				String birth = request.getParameter("yy")+"-"+request.getParameter("mm")+"-"+request.getParameter("dd");
				Date d = Date.valueOf(birth);
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pswd1"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setNickname(request.getParameter("nickname"));
				memberDTO.setBirth(d);
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setAddress(request.getParameter("address"));
				memberDTO.setEmail(request.getParameter("email"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
		int result = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			result = memberdao.memberJoin(memberDTO, con);
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try{
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	
		if(result>0) {
			check = false;
			path = "../index.do";
		}else {
			request.setAttribute("message", "Join Fail");
			request.setAttribute("path", "./memberJoin");;
			check = true;
			path = "../WEB-INF/views/common/result.jsp";
		}
	
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
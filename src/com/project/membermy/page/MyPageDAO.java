package com.project.membermy.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.member.MemberDTO;


public class MyPageDAO {
	
	public int pwCheck(String pw, Connection con)throws Exception{
		String sql = "select pw from member where pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, pw);
		ResultSet rs = st.executeQuery();
		int check=0;
		if(rs.next()) {
			check=1;
			
		}
		rs.close();
		st.close();
		return check;
		
	}
	
	
	public MemberDTO memberMyPage(MemberDTO dto, Connection con) throws Exception{
		MemberDTO m = null;
		String sql = "select * from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getId());
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			m= new MemberDTO();
			m.setId(rs.getString("id"));
			m.setName(rs.getString("name"));
			m.setNickname(rs.getString("nickname"));
			m.setBirth(rs.getDate("birth"));
			m.setPhone(rs.getString("phone"));
			m.setAddress(rs.getString("address"));
			m.setEmail(rs.getString("email"));
			
		}
		
		rs.close();
		st.close();
		
		return m;
	}
	
	public int memberMyUpdate(MemberDTO dto, Connection con) throws Exception{
	
		String sql = "update member set name=?, nickname=?, phone=?, address=?, email=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getName());
		st.setString(2, dto.getNickname());
		st.setString(3, dto.getPhone());
		st.setString(4, dto.getAddress());
		st.setString(5, dto.getEmail());
		st.setString(6, dto.getId());
		
		int result = st.executeUpdate(); //실패 0
		st.close();
		return result;
	}
	
	public int memberMyPwUpdate(MemberDTO dto, Connection con) throws Exception{
		int result = 0;
		String sql = "update member set pw=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getPw());
		st.setString(2, dto.getId());
		
		
		result = st.executeUpdate(); //실패 0
		st.close();
		return result;
	}
	
	
}



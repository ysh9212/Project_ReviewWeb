package com.project.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.project.util.DBConnector;

public class MemberDAO {
	
	public int idCheck(String id, Connection con)throws Exception{
		String sql = "select id from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		int check=1;
		if(rs.next()) {
			check=0;
			
		}
		rs.close();
		st.close();
		return check;
		
	}
	
	public int nicknameCheck(String nickname, Connection con)throws Exception{
		String sql = "select nickname from member where nickname=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, nickname);
		ResultSet rs = st.executeQuery();
		int check=1;
		if(rs.next()) {
			check=0;
		}
		rs.close();
		st.close();
		return check;
		
	}
	
	public MemberDTO memberLogin(MemberDTO dto) throws Exception{
		MemberDTO m = null;
		Connection con = DBConnector.getConnect();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			m= new MemberDTO();
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setNickname(rs.getString("nickname"));
			m.setBirth(rs.getDate("birth"));
			m.setPhone(rs.getString("phone"));
			m.setAddress(rs.getString("address"));
			m.setEmail(rs.getString("email"));
			
		}
		DBConnector.disConnect(rs, st, con);
		
		return m;
	}
	
	public int memberJoin(MemberDTO dto, Connection con) throws Exception{
		
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setString(4, dto.getNickname());
		st.setDate(5, dto.getBirth());
		st.setString(6, dto.getPhone());
		st.setString(7, dto.getAddress());
		st.setString(8, dto.getEmail());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public MemberDTO memberSearchId(MemberDTO memberDTO, Connection con) throws Exception{
		MemberDTO m = null;
		
		String sql = "select id,name from member where name=? and email=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getName());
		st.setString(2, memberDTO.getEmail());
		
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			m = new MemberDTO();
			m.setName(rs.getString("name"));
			m.setId(rs.getString("id"));
	
		}
		
		st.close();
		return m;
	}
	
	public MemberDTO memberSearchPw(MemberDTO dto, Connection con) throws Exception{
		MemberDTO m = null;
		
		String sql = "select name, email from member where id=? and name=? and email=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getName());
		st.setString(3, dto.getEmail());
		
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			m = new MemberDTO();
			m.setId(rs.getString("name"));
			m.setName(rs.getString("email"));
	
		}
		
		
		st.close();
		return m;
	}
}

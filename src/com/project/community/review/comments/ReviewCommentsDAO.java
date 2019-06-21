package com.project.community.review.comments;

import java.sql.Connection;
import java.util.List;

import com.project.community.comments.CommunityCommentsDAO;
import com.project.community.comments.CommunityCommentsDTO;
import com.project.shopPage.SearchRow;

public class ReviewCommentsDAO implements CommunityCommentsDAO{

	@Override
	public List<CommunityCommentsDTO> selectList(SearchRow searchRow, int no, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int cno, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

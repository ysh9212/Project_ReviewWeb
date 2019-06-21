package com.project.community.comments;

import java.sql.Connection;
import java.util.List;

import com.project.shopPage.SearchRow;

public interface CommunityCommentsDAO {
	
	public List<CommunityCommentsDTO> selectList(SearchRow searchRow, int no, Connection con )throws Exception;

	public int insert(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception;
	
	public int update(CommunityCommentsDTO communityCommentsDTO, Connection con) throws Exception;

	public int delete(int cnum, Connection con) throws Exception;
}

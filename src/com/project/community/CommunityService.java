package com.project.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;

public class CommunityService implements Action{
	
	public ActionForward allList(HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("allList"); µµÂø È®ÀÎ;
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/views/community/communityList.jsp");
		
		return actionForward;
	}

	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("notice"); µµÂøÈ®ÀÎ;
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/views/community/communityNotice.jsp");
		
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}

}

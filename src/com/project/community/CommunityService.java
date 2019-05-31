package com.project.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.action.Action;
import com.project.action.ActionForward;

public class CommunityService implements Action{

	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
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
	
	public ActionForward notice(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}
	
	public ActionForward board(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}
	
	public ActionForward review(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}
	
	public ActionForward used(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}
	
	public ActionForward qna(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}
	
	public ActionForward bug(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		return actionForward;
	}
	
	

}

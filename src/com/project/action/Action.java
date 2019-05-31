package com.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public abstract ActionForward list(HttpServletRequest request, HttpServletResponse response);

	public abstract ActionForward select(HttpServletRequest request, HttpServletResponse response);

	public abstract ActionForward insert(HttpServletRequest request, HttpServletResponse response);

	public abstract ActionForward update(HttpServletRequest request, HttpServletResponse response);

	public abstract ActionForward delete(HttpServletRequest request, HttpServletResponse response);


}

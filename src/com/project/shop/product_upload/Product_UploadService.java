package com.project.shop.product_upload;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.util.DBConnector;

public class Product_UploadService implements Action {
	private Product_UploadDAO product_UploadDAO;
	public Product_UploadService() {
		product_UploadDAO = new Product_UploadDAO();
	}
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		int maxPostSize = 50*1024*1024;
		String saveDirectory = request.getServletContext().getRealPath("upload");
		
		File file = new File(saveDirectory);
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());
			String callback = multipartRequest.getParameter("callback");
			String callback_func = multipartRequest.getParameter("callback_func");
			String fileName = multipartRequest.getFilesystemName("Filedata");
			
			//1.절대 경로
			String path = request.getContextPath();
			//2. 최종 결과물
			String result = "&bNewLine=true&sFileURL="+path+"/uplad_se2/"+fileName;
			//3.
			result = callback+ "?callback_func="+callback_func+result;
			
			request.setAttribute("result", result);
			actionForward.setPath(result);
			actionForward.setCheck(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return actionForward;
	}
	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			int pno = Integer.parseInt(request.getParameter("pno"));
			result = product_UploadDAO.delete(pno, con);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("result", result);
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/views/common/result2.jsp");
		return actionForward;
	}
	
}

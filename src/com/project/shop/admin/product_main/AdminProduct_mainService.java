package com.project.shop.admin.product_main;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.shop.admin.product_upload.Product_UploadDAO;
import com.project.shop.admin.product_upload.Product_UploadDTO;
import com.project.util.DBConnector;

public class AdminProduct_mainService implements Action {
	private AdminProduct_mainDAO adminProduct_mainDAO;
	private Product_UploadDAO product_UploadDAO;
	public AdminProduct_mainService() {
		adminProduct_mainDAO = new AdminProduct_mainDAO();
		product_UploadDAO = new Product_UploadDAO();
	}
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		
		
		return actionForward;
	}

	@Override
	public ActionForward select(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		Connection con = null;
		AdminProduct_mainDTO adminProduct_mainDTO = null;
		
		try {
			con =DBConnector.getConnect();
			int product_main_no = Integer.parseInt(request.getParameter("product_main_no"));
			adminProduct_mainDTO = adminProduct_mainDAO.selectOne(product_main_no, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String path = "";
		if(adminProduct_mainDTO!= null) {
			request.setAttribute("dto", adminProduct_mainDTO);
			request.setAttribute("board", "product_main");
			path="../../../WEB-INF/views/admin/shop/product/product_mainSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./product_mainList");
			path="../../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		
		
		return actionForward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		boolean check = true;
		String path = "../../../WEB-INF/views/admin/shop/product/product_main.jsp";
		if(method.equals("POST")) {
			String saveDirectory = request.getServletContext().getRealPath("upload");
			File file = new File(saveDirectory);
			if(!file.exists()) {
				file.mkdirs();
			}
			int maxPostSize = 100*1024*1024;
			Connection con = null;
			
			try {
				MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());
				Enumeration<String> e = multipartRequest.getFileNames();
				ArrayList<Product_UploadDTO> ar = new ArrayList<Product_UploadDTO>();
				while(e.hasMoreElements()) {
					String s = e.nextElement();
					String fname = multipartRequest.getFilesystemName(s);
					String oname = multipartRequest.getOriginalFileName(s);
					Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
					product_UploadDTO.setFname(fname);
					product_UploadDTO.setOname(oname);
					ar.add(product_UploadDTO);
				}
				AdminProduct_mainDTO adminProduct_mainDTO = new AdminProduct_mainDTO();
				adminProduct_mainDTO.setProduct_no(Integer.parseInt(multipartRequest.getParameter("product_no")));
				adminProduct_mainDTO.setProduct_category_no(Integer.parseInt(multipartRequest.getParameter("product_category_no")));
				adminProduct_mainDTO.setProduct_title(multipartRequest.getParameter("product_title"));
				adminProduct_mainDTO.setProduct_detail(multipartRequest.getParameter("product_detail"));
				adminProduct_mainDTO.setCart_no(Integer.parseInt(multipartRequest.getParameter("cart_no")));
				
				int product_main_no = adminProduct_mainDAO.getNum();
				adminProduct_mainDTO.setProduct_main_no(product_main_no);
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				int result = adminProduct_mainDAO.insert(adminProduct_mainDTO, con);
				
				//upload insert
				Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
				product_UploadDTO.setNo(adminProduct_mainDTO.getProduct_no());
				result = product_UploadDAO.insert(product_UploadDTO, con);
				if(result<1) {
					throw new Exception();
				}
				con.commit();
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
		}//post
		
		return actionForward;
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

package com.project.shop.admin.product_main;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.action.Action;
import com.project.action.ActionForward;
import com.project.shop.admin.product_upload.Product_UploadDAO;
import com.project.shop.admin.product_upload.Product_UploadDTO;
import com.project.shopPage.SearchMakePage;
import com.project.shopPage.SearchPager;
import com.project.shopPage.SearchRow;
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
		int curPage = 1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		SearchMakePage s = new SearchMakePage(curPage, kind, search);
		
		SearchRow searchRow = s.makeRow();
		int totalCount = 0;
		Connection con = null;
		
		try {
			con = DBConnector.getConnect();
			List<AdminProduct_mainDTO> ar = adminProduct_mainDAO.selectList(searchRow, con);
			totalCount = adminProduct_mainDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			request.setAttribute("board", "product_main");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/admin/shop/product/product_mainList.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../../admin.do");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/common/result2.jsp");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
			
		
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
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}finally {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			actionForward.setCheck(false);
			actionForward.setPath("./product_mainList");
		}//post
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "../../../WEB-INF/views/admin/shop/product/product_mainList.jsp";
		String method = request.getMethod();
		if(method.equals("POST")) {
			Connection con = null;
			int result = 0;
			
			try {
				con=DBConnector.getConnect();
				AdminProduct_mainDTO adminProduct_mainDTO = new AdminProduct_mainDTO();
				adminProduct_mainDTO.setProduct_category_no(Integer.parseInt(request.getParameter("product_category_no")));
				adminProduct_mainDTO.setProduct_no(Integer.parseInt(request.getParameter("product_no")));
				adminProduct_mainDTO.setProduct_title(request.getParameter("product_title"));
				adminProduct_mainDTO.setProduct_detail(request.getParameter("product_detail"));
				adminProduct_mainDTO.setCart_no(Integer.parseInt(request.getParameter("cart_no")));
				result = adminProduct_mainDAO.update(adminProduct_mainDTO, con);
				
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
			check = true;
			path = "./product_mainList";
		}//get
		actionForward.setCheck(check);
		actionForward.setPath(path);
		return actionForward;
	}

	@Override
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "";
		Connection con = null;
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			int product_main_no = Integer.parseInt(request.getParameter("product_main_no"));
			result = adminProduct_mainDAO.delete(product_main_no, con);
			if(result>0) {
				check = false;
				path="./product_mainList";
			}else {
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./product_mainList");
				check = true;
				path = "../../../WEB-INF/views/common/result.jsp";
			}
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
		actionForward.setCheck(check);
		actionForward.setPath(path);
		
		return actionForward;
	}

}

package com.project.shop.admin.product;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
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

public class ProductService implements Action{
	private ProductDAO productDAO;
	private Product_UploadDAO product_UploadDAO;
	public ProductService() {
		productDAO = new ProductDAO();
		product_UploadDAO = new Product_UploadDAO();
	}
	@Override
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		
		int curPage= 1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		SearchMakePage s = new SearchMakePage(curPage, kind, search);
		
		SearchRow searchRow = s.makeRow();
		List<ProductDTO> ar = null;
		Connection con = null;
		try {
			con = DBConnector.getConnect();
			ar = productDAO.selectList(searchRow, con);
			
			int totalCount = productDAO.getTotalCount(searchRow, con);
			SearchPager searchPager = s.makePage(totalCount);
			
			request.setAttribute("pager", searchPager);
			request.setAttribute("list", ar);
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/admin/shop/product/productList.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", "Server Error");
			request.setAttribute("path", "../productList");
			actionForward.setCheck(true);
			actionForward.setPath("../../../WEB-INF/views/common/result.jsp");
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
		ProductDTO productDTO = null;
		Product_UploadDTO product_UploadDTO = null;
		Connection con = null;
		
		try {
			con=DBConnector.getConnect();
			int pno = Integer.parseInt(request.getParameter("pno"));
			productDTO = productDAO.selectOne(pno, con);
			product_UploadDTO = product_UploadDAO.selectOne(pno, con);
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
		if(productDTO != null) {
			request.setAttribute("dto", productDTO);
			request.setAttribute("upload", product_UploadDTO);
			path="../../../WEB-INF/views/admin/shop/product/productSelect.jsp";
		}else {
			request.setAttribute("message", "No Data");
			request.setAttribute("path", "./productList");
			path = "../../../WEB-INF/views/common/result.jsp";
		}
		actionForward.setCheck(true);
		actionForward.setPath(path);
		
		return actionForward;
	}

	@Override
	public ActionForward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		actionForward.setCheck(true);
		actionForward.setPath("../../../WEB-INF/views/admin/shop/product/productWrite.jsp");
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			String saveDirectory = request.getServletContext().getRealPath("upload");
			System.out.println("pro"+saveDirectory);
			File file = new File(saveDirectory);
			if(!file.exists()) {
				file.mkdirs();
			}
			int maxPostSize = 1024*1024*100;
			Connection con = null;
			try {
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());
				Enumeration<String> e = multipartRequest.getFileNames();
				Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
				while(e.hasMoreElements()) {
					String s = e.nextElement();
					String fname = multipartRequest.getFilesystemName(s);
					String oname = multipartRequest.getOriginalFileName(s);
					product_UploadDTO.setFname(fname);
					product_UploadDTO.setOname(oname);
				}
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setTitle(multipartRequest.getParameter("title"));
				productDTO.setDetail(multipartRequest.getParameter("contents"));
				productDTO.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
				productDTO.setStock(Integer.parseInt(multipartRequest.getParameter("stock")));
				productDTO.setCno(Integer.parseInt(multipartRequest.getParameter("kind")));
				int pno = productDAO.getNum();
				productDTO.setPno(pno);
				pno = productDAO.insert(productDTO, con);
				if(pno<1) {
					throw new Exception();
				}
				product_UploadDTO.setPno(productDTO.getPno());
				pno = product_UploadDAO.insert(product_UploadDTO, con);
				if(pno<1) {
					throw new Exception();
				}
				con.commit();
				actionForward.setCheck(false);
				actionForward.setPath("./productList");
			} catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message", "Insert Fail");
				request.setAttribute("path", "./productList");;
				actionForward.setCheck(true);
				actionForward.setPath("../../../WEB-INF/views/common/result.jsp");
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
			
		}//post 끝
		
		
		return actionForward;
	}

	@Override
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = new ActionForward();
		boolean check = true;
		String path = "../../../WEB-INF/views/admin/shop/product/productUpdate.jsp";
		String method = request.getMethod();
		if(method.equals("POST")) {
			String saveDirectory = request.getServletContext().getRealPath("upload");
			File file = new File(saveDirectory);
			if(!file.exists()) {
				file.mkdirs();
			}
			int maxPostSize = 1024*1024*100;
			Connection con = null;
			int result = 0;
			
			try {
				MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());
				Enumeration<String> e = multipartRequest.getFileNames();
				Product_UploadDTO product_UploadDTO = new Product_UploadDTO();
				while(e.hasMoreElements()) {
					String s = e.nextElement();
					String fname = multipartRequest.getFilesystemName(s);
					String oname = multipartRequest.getOriginalFileName(s);
					product_UploadDTO.setFname(fname);
					product_UploadDTO.setOname(oname);
				}
				if(product_UploadDTO.getOname() == null) {
					product_UploadDTO.setFname(multipartRequest.getParameter("fname"));
					product_UploadDTO.setOname(multipartRequest.getParameter("oname"));
				}
				con=DBConnector.getConnect();
				ProductDTO productDTO = new ProductDTO();
				productDTO.setTitle(multipartRequest.getParameter("title"));
				productDTO.setDetail(multipartRequest.getParameter("contents"));
				productDTO.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
				productDTO.setStock(Integer.parseInt(multipartRequest.getParameter("stock")));
				productDTO.setCno(Integer.parseInt(multipartRequest.getParameter("kind")));
				
				productDTO.setPno(Integer.parseInt(multipartRequest.getParameter("pno")));
				con.setAutoCommit(false);
				
				result = productDAO.update(productDTO, con);
				if(result<1) {
					throw new Exception();
				}
				product_UploadDTO.setPno(productDTO.getPno());
				result = product_UploadDAO.insert(product_UploadDTO, con);
				if(result<1) {
					throw new Exception();
				}
				con.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "Update Fail");
				request.setAttribute("path", "./productList");;
				check = true;
				path = "../../../WEB-INF/views/common/result.jsp";
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
			check = true;
			path = "./productList";
		}//post끝
		else {
			int pno = Integer.parseInt(request.getParameter("pno"));
			Connection con = null;
			ProductDTO productDTO = null;
			Product_UploadDTO product_UploadDTO = null;
			try {
				con = DBConnector.getConnect();
				productDTO = productDAO.selectOne(pno, con);
				product_UploadDTO = product_UploadDAO.selectOne(pno, con);
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
			}//finally
			request.setAttribute("dto", productDTO);
			request.setAttribute("upload", product_UploadDTO);
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
			int pno = Integer.parseInt(request.getParameter("pno"));
			result = productDAO.delete(pno, con);
			if(result>0) {
				check = false;
				path = "./productList";
			} else {
				request.setAttribute("message", "Delete Fail");
				request.setAttribute("path", "./productList");;
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

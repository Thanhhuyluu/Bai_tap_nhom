package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bean.ChuyenMuc;
import model.bo.BaiDangBO;
import model.bo.ChuyenMucBO;

/**
 * Servlet implementation class PostDetailController
 */
@WebServlet("/postDetail")
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maBaiDang = Integer.parseInt(request.getParameter("id"));
		
		BaiDangBO baiDangBO = new BaiDangBO();
		ChuyenMucBO chuyenMucBO = new ChuyenMucBO();
		
		try {
			BaiDang baiDang = baiDangBO.getBaiDangByID(maBaiDang);
			List<ChuyenMuc> listChuyenMuc = chuyenMucBO.getAllByMaBaiDang(maBaiDang);
			
			request.setAttribute("baiDang", baiDang);
			request.setAttribute("listChuyenMuc", listChuyenMuc);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/post_detail.jsp");
            dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching post details.");
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

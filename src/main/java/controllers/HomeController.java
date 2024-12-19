package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BaiDangBO;
import model.bean.*;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/trang-chu")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BaiDangBO baiDangBO = new BaiDangBO();
		
		String search =request.getParameter("search");
		if(search == null) search = "";
		try {
			List<BaiDang> listBaiDang =  baiDangBO.getBySearch(search);
			request.setAttribute("listBaiDang", listBaiDang);
			request.setAttribute("search", search);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving posts");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

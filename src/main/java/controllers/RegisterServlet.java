package controllers;

import model.bo.NguoiDungBO;
import model.bean.NguoiDung;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fullName = request.getParameter("fullname");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String confirmPassword = request.getParameter("password_confirmation");

	        NguoiDungBO nguoiDungBO = new NguoiDungBO();

	        try {
	            if (!password.equals(confirmPassword)) {
	                // Mật khẩu không khớp
	                request.setAttribute("error", "Mật khẩu và xác nhận mật khẩu không khớp!");
	                request.getRequestDispatcher("register.jsp").forward(request, response);
	                return;
	            }

	            NguoiDung nguoiDung = new NguoiDung(fullName,0, email, password);
	            if (nguoiDungBO.registerUser(nguoiDung)) {
	                // Đăng ký thành công
	                response.sendRedirect("login.jsp");
	            } else {
	                // Email đã tồn tại
	                request.setAttribute("error", "Email đã tồn tại!");
	                request.getRequestDispatcher("register.jsp").forward(request, response);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}

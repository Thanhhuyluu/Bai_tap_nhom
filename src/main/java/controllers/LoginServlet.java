package controllers;

import model.bean.NguoiDung;
import model.bo.NguoiDungBO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.RepaintManager;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Chuyển hướng đến trang login.jsp
//        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//        dispatcher.forward(request, response);
    
    	doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        NguoiDungBO nguoiDungBO = new NguoiDungBO();

        try {
            if (nguoiDungBO.checkLogin(email, password)) {
                // Đăng nhập thành công
            	
            	NguoiDung nguoiDung = nguoiDungBO.getByEmailAndPassword(email, password);
            	
            	request.getSession().setAttribute("userId", nguoiDung.getMaNguoiDung());
                request.getSession().setAttribute("user", email);
                
                if(nguoiDung.getVaiTro() == 1) 
                    response.sendRedirect("admin-xem-bai-dang");
                else 
                response.sendRedirect("trang-chu");
            } else {
                // Đăng nhập thất bại
                request.setAttribute("error", "Email hoặc mật khẩu không đúng!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

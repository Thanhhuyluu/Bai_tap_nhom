package controllers.admin;

import java.awt.PageAttributes.OrientationRequestedType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NguoiDung;
import model.bo.NguoiDungBO;

/**
 * Servlet implementation class NguoiDungController
 */
@WebServlet(urlPatterns = {"/admin-xem-nguoi-dung", "/admin-sua-nguoi-dung", "/admin-them-nguoi-dung", "/admin-xoa-nguoi-dung"})
public class NguoiDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDungController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getServletPath();
		System.out.print(action);
		
		switch (action) {
		case "/admin-xem-nguoi-dung": 
			XemNguoiDung(request, response);
			break;
		case "/admin-sua-nguoi-dung":
			try {
				SuaNguoiDung(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "/admin-them-nguoi-dung":
			try {
				ThemNguoiDung(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "/admin-xoa-nguoi-dung":
			try {
				XoaNguoiDung(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		}
	}
	
	

	private void XoaNguoiDung(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		int maNguoiDung = Integer.parseInt(request.getParameter("maNguoiDung"));
		
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		try {
			nguoiDungBO.deleteNguoiDung(maNguoiDung);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		nguoiDungBO.deleteNguoiDung(maNguoiDung);
		XemNguoiDung(request, response);
		
	}

	private void ThemNguoiDung(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void SuaNguoiDung(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void XemNguoiDung(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		
		List<NguoiDung> listNguoiDung = new ArrayList<NguoiDung>();
		try {
			listNguoiDung = nguoiDungBO.getAllNguoiDung();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.setAttribute("listNguoiDung", listNguoiDung);
		request.getRequestDispatcher("/admin/ListNguoiDung.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

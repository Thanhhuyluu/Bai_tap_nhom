package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhuVuc;
import model.bo.KhuVucBO;

/**
 * Servlet implementation class KhuVucController
 */
@WebServlet(urlPatterns = {"/admin-xem-khu-vuc", "/admin-sua-khu-vuc", "/admin-xoa-khu-vuc"})
public class KhuVucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhuVucController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String acction = request.getServletPath();
		System.out.print(acction);
		
		switch (acction) {
		case "/admin-xem-khu-vuc": 
			XemKhuVuc(request, response);
			break;
		case "/admin-sua-khu-vuc":
			try {
				SuaKhuVuc(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "/admin-xoa-khu-vuc":
			try {
				XoaKhuVuc(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + acction);
		}
		
	}

	private void XoaKhuVuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		int maKhuVuc = Integer.parseInt(request.getParameter("id"));
		
		KhuVucBO khuVucBO = new KhuVucBO();
		
		try {
			khuVucBO.deleteBaiDang(maKhuVuc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		XemKhuVuc(request, response);
		
	}

	private void SuaKhuVuc(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void XemKhuVuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhuVucBO khuVucBO = new KhuVucBO();
		List<KhuVuc> listKhuVuc = new ArrayList<KhuVuc>();
		
		try {
			listKhuVuc = khuVucBO.getAllKhuVuc();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.setAttribute("listKhuVuc", listKhuVuc);
		request.getRequestDispatcher("/admin/ListKhuVuc.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

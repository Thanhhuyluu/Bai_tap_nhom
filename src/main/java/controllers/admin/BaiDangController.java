package controllers.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bean.ChuyenMuc;
import model.bean.DiaDiem;
import model.bean.KhuVuc;
import model.bo.BaiDangBO;
import model.bo.ChuyenMucBO;
import model.bo.DiaDiemBO;
import model.bo.KhuVucBO;

/**
 * Servlet implementation class BaiDangController
 */
@WebServlet( urlPatterns = { "/admin-xem-bai-dang", "/admin-xu-ly-them-bai-dang" , "/admin-them-bai-dang" , "/admin-xoa-bai-dang", "/admin-sua-bai-dang", "/admin-xu-ly-sua-bai-dang","/admin-xem-chi-tiet-bai-dang"})
public class BaiDangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaiDangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		

		request.setCharacterEncoding("UTF-8");
		String action = request.getServletPath();
		System.out.println(action);
        switch (action) {
		case "/admin-xem-bai-dang":
		    XemBaiDang(request, response);
		    break;
		case "/admin-xu-ly-them-bai-dang":
		    try {
				XuLyThem(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    break;
		case "/admin-them-bai-dang":
		    try {
				ThemBaiDang(request, response);
			} catch (IOException | ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    break;
		    
		case "/admin-xoa-bai-dang":
			try {
				XoaBaiDang(request, response);
			} catch (IOException | ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "/admin-sua-bai-dang":
			try {
				SuaBaiDang(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/admin-xu-ly-sua-bai-dang":
			try {
				XuLySuaBaiDang(request, response);
			} catch (NumberFormatException | SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "/admin-xem-chi-tiet-bai-dang":
			try {
				XemChiTietBaiBang(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
		    XemBaiDang(request, response);
		    break;
		}
		
	}

	
	private void XemChiTietBaiBang(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		int maBaiDang = Integer.parseInt(request.getParameter("maBaiDang"));

		BaiDangBO baiDangBO = new BaiDangBO();
		ChuyenMucBO chuyenMucBO = new ChuyenMucBO();
		DiaDiemBO diaDiemBO = new DiaDiemBO();
		BaiDang baiDang= baiDangBO.getBaiDangByID(maBaiDang);
		List<ChuyenMuc> chuyenMucList = chuyenMucBO.getAllByMaBaiDang(maBaiDang);

		DiaDiem diaDiem = diaDiemBO.getById(baiDang.getMaDiaDiem());

		request.setAttribute("diaDiem", diaDiem);
		request.setAttribute("chuyenMucList", chuyenMucList);
		request.setAttribute("baiDang", baiDang);
		request.getRequestDispatcher("/admin/xem_chi_tiet_bai_dang.jsp").forward(request, response);
		
	}

	private void XuLySuaBaiDang(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, ServletException, IOException {
		int maBaiDang = Integer.parseInt(request.getParameter("maBaiDang"));
		String tenBaiDang = request.getParameter("post-title");
		String moTaBaiDang = request.getParameter("description");
		int maKhuVuc = Integer.parseInt(request.getParameter("region"));
		String hinhAnh = request.getParameter("img");
		int maDiaDiem = Integer.parseInt(request.getParameter("diaDiem"));
		
		// Sửa thêm id người dùng vào
		
		BaiDang baiDang = new BaiDang(maBaiDang,tenBaiDang, maDiaDiem, moTaBaiDang, 1	, hinhAnh);
		System.out.println(hinhAnh);
		
		BaiDangBO baiDangBO = new BaiDangBO();
		baiDangBO.updateBaiDang(baiDang);
		
		
		String[] tenChuyenMuc = request.getParameterValues("topic-name[]");

		String[] moTaChuyenMuc = request.getParameterValues("topic-description[]");
		
		String[] hinhAnhChuyenMuc = request.getParameterValues("topic-image[]");

		String[] maChuyenMucList = request.getParameterValues("maChuyenMucList[]");
		
		List<ChuyenMuc> chuyenMucList = new ArrayList<ChuyenMuc>();
		
		ChuyenMucBO chuyenMucBO = new ChuyenMucBO();
		if( maChuyenMucList != null ) {
			for(int i = 0; i < maChuyenMucList.length; i++) {
				chuyenMucBO.deleteChuyenMuc(Integer.parseInt(maChuyenMucList[i]));
			}
		}
		for(int i = 0; i < tenChuyenMuc.length; i++) {
			ChuyenMuc chuyenMuc = new ChuyenMuc(maBaiDang, tenChuyenMuc[i], moTaChuyenMuc[i], hinhAnhChuyenMuc[i]);
			System.out.println(chuyenMuc.getMoTa());
			chuyenMucBO.addChuyenMuc(chuyenMuc);
		}
		XemBaiDang(request,response);
		
	}

	private void SuaBaiDang(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
		int maBaiDang = Integer.parseInt(request.getParameter("maBaiDang"));
		BaiDangBO baiDangBO = new BaiDangBO();
		BaiDang baiDang = baiDangBO.getBaiDangByID(maBaiDang);
		ChuyenMucBO chuyenMucBO = new ChuyenMucBO();
		
		List<KhuVuc> khuVucList = new ArrayList<KhuVuc>();
		List<DiaDiem> diaDiemList = new ArrayList<DiaDiem>();
		KhuVucBO khuVucBO = new KhuVucBO();
		DiaDiemBO diaDiemBO = new DiaDiemBO();
		try {
			khuVucList = khuVucBO.getAllKhuVuc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		diaDiemList = diaDiemBO.getAllDiaDiem();

		DiaDiem diaDiem = diaDiemBO.getById(baiDang.getMaDiaDiem());
		
		List<ChuyenMuc> chuyenMucList = chuyenMucBO.getAllByMaBaiDang(maBaiDang);
		

		request.setAttribute("chuyenMucList", chuyenMucList);
		request.setAttribute("diaDiemList", diaDiemList);
		request.setAttribute("khuVucList", khuVucList);
		request.setAttribute("baiDang", baiDang);
		request.setAttribute("diaDiem", diaDiem);
		

		request.getRequestDispatcher("/admin/sua_bai_dang.jsp").forward(request, response);
	}

	private void XoaBaiDang(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		int maBaiDang = Integer.parseInt(request.getParameter("maBaiDang"));

		BaiDangBO baiDangBO = new BaiDangBO();
		ChuyenMucBO chuyenMucBO  = new ChuyenMucBO();

		chuyenMucBO.deleteByMaBaiDang(maBaiDang);
		baiDangBO.deleteBaiDang(maBaiDang);
		XemBaiDang(request,response);
		
	}

	private void ThemBaiDang(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		
		List<KhuVuc> khuVucList = new ArrayList<KhuVuc>();
		List<DiaDiem> diaDiemList = new ArrayList<DiaDiem>();
		KhuVucBO khuVucBO = new KhuVucBO();
		DiaDiemBO diaDiemBO = new DiaDiemBO();
		try {
			khuVucList = khuVucBO.getAllKhuVuc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		diaDiemList = diaDiemBO.getAllDiaDiem();

		request.setAttribute("diaDiemList", diaDiemList);
		request.setAttribute("khuVucList", khuVucList);
		
		request.getRequestDispatcher("/admin/them_bai_dang_form.jsp").forward(request, response);
	}

	private void XuLyThem(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String tenBaiDang = request.getParameter("post-title");
		String moTaBaiDang = request.getParameter("description");
		int maKhuVuc = Integer.parseInt(request.getParameter("region"));
		String hinhAnh = request.getParameter("img");
		
		int maDiaDiem = Integer.parseInt(request.getParameter("diaDiem"));
		
		// Sửa thêm id người dùng vào
		
		BaiDang baiDang = new BaiDang(tenBaiDang, maDiaDiem, moTaBaiDang, 1	, hinhAnh);
		
		BaiDangBO baiDangBO = new BaiDangBO();
		int idBaiDang = baiDangBO.addBaiDang(baiDang);
		
		
		String[] tenChuyenMuc = request.getParameterValues("topic-name[]");

		String[] moTaChuyenMuc = request.getParameterValues("topic-description[]");
		
		String[] hinhAnhChuyenMuc = request.getParameterValues("topic-image[]");
		
		List<ChuyenMuc> chuyenMucList = new ArrayList<ChuyenMuc>();
		
		ChuyenMucBO chuyenMucBO = new ChuyenMucBO();
		for(int i = 0; i < tenChuyenMuc.length; i++) {
			ChuyenMuc chuyenMuc = new ChuyenMuc(idBaiDang, tenChuyenMuc[i], moTaChuyenMuc[i], hinhAnhChuyenMuc[i]);
			System.out.println(chuyenMuc.getMoTa());
			chuyenMucBO.addChuyenMuc(chuyenMuc);
		}
		
		
		System.out.print(tenBaiDang + " " + moTaBaiDang + " " + maKhuVuc);
		XemBaiDang(request,response);
	}

	private void XemBaiDang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
					BaiDangBO baiDangBO = new BaiDangBO();
					KhuVucBO khuVucBO = new KhuVucBO();
					
					List<BaiDang> list = new ArrayList<BaiDang>();
					try {
						list = baiDangBO.getAllBaiDang();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<KhuVuc> khuVucList = new ArrayList<KhuVuc>();
					
					try {
						khuVucList = khuVucBO.getAllKhuVuc();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					request.setAttribute("khuVucList", khuVucList);
					request.setAttribute("list", list);
					request.getRequestDispatcher("/admin/ListBaiDang.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

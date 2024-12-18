package model.bo;


import model.bean.*;
import model.dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NguoiDungBO {
	private NguoiDungDAO nguoiDungDAO;

    public NguoiDungBO() {
        this.nguoiDungDAO = new NguoiDungDAO();
    }
    
    // Kiểm tra thông tin đăng nhập của admin
    public boolean checkLogin(String username, String password) throws SQLException {
        return nguoiDungDAO.checkLoginDAO(username, password);
    }
    
    // Kiểm tra sự tồn tại của người dùng theo tên người dùng
    public boolean isUsernameExists(String username) throws SQLException {
        return nguoiDungDAO.isUsernameExists(username); 
    }

    // Lấy tất cả người dùng
    public List<NguoiDung> getAllNguoiDung() throws SQLException {
        return nguoiDungDAO.getAll();
    }

    // Thêm người dùng mới
    public void addNguoiDung(NguoiDung nguoiDung) throws SQLException {
        nguoiDungDAO.insert(nguoiDung);
    }

    // Cập nhật người dùng
    public void updateNguoiDung(NguoiDung nguoiDung) throws SQLException {
        nguoiDungDAO.update(nguoiDung);
    }

    // Xóa người dùng theo ID
    public void deleteNguoiDung(int maNguoiDung) throws SQLException {
        nguoiDungDAO.delete(maNguoiDung);
    }
   
}

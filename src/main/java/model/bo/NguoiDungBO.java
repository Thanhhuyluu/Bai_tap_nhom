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
    
 // Kiểm tra thông tin đăng nhập
    public boolean checkLogin(String email, String password) throws SQLException {
        return nguoiDungDAO.checkLogin(email, password);
    }

    // Kiểm tra sự tồn tại của email
    public boolean isEmailExists(String email) throws SQLException {
        return nguoiDungDAO.isEmailExists(email);
    }

    // Thêm người dùng mới
    public boolean registerUser(NguoiDung nguoiDung) throws SQLException {
        if (isEmailExists(nguoiDung.getEmail())) {
            return false; // Email đã tồn tại
        }
        nguoiDungDAO.insertUser(nguoiDung);
        return true;
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

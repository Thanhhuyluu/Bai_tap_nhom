package models.dao;

import models.bean.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private Connection conn;

    public NguoiDungDAO() {
        conn = DBConnection.getConnection();  // Kết nối với cơ sở dữ liệu
    }
    
 // Kiểm tra thông tin đăng nhập của admin
    public boolean checkLoginDAO(String username, String password) throws SQLException {
        String query = "SELECT * FROM nguoi_dung WHERE ten_nguoi_dung = ? AND mat_khau = ? AND vai_tro = 1"; // vai_tro = 1 cho admin
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        }
    }

 // Kiểm tra sự tồn tại của người dùng theo tên người dùng
    public boolean isUsernameExists(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM nguoi_dung WHERE ten_nguoi_dung = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error checking if username exists", e);
        }
        return false; 
    }

    // Lấy tất cả người dùng
    public List<NguoiDung> getAll() throws SQLException {
        List<NguoiDung> list = new ArrayList<>();
        String query = "SELECT * FROM nguoi_dung";

        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NguoiDung nguoiDung = new NguoiDung(
                        rs.getInt("ma_nguoi_dung"),
                        rs.getString("ten_nguoi_dung"),
                        rs.getInt("vai_tro"),
                        rs.getString("mat_khau"),
                        rs.getString("email")
                );
                list.add(nguoiDung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while fetching data from NguoiDung table.", e);
        }
        return list;
    }

    // Thêm người dùng mới
    public void insert(NguoiDung nguoiDung) throws SQLException {
        String query = "INSERT INTO nguoi_dung (ten_nguoi_dung, vai_tro, mat_khau, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nguoiDung.getTenNguoiDung());
            ps.setInt(2, nguoiDung.getVaiTro());
            ps.setString(3, nguoiDung.getMatKhau());
            ps.setString(4, nguoiDung.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while inserting data into NguoiDung table.", e);
        }
    }

    // Cập nhật người dùng
    public void update(NguoiDung nguoiDung) throws SQLException {
        String query = "UPDATE nguoi_dung SET ten_nguoi_dung = ?, vai_tro = ?, mat_khau = ?, email = ? WHERE ma_nguoi_dung = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nguoiDung.getTenNguoiDung());
            ps.setInt(2, nguoiDung.getVaiTro());
            ps.setString(3, nguoiDung.getMatKhau());
            ps.setString(4, nguoiDung.getEmail());
            ps.setInt(5, nguoiDung.getMaNguoiDung());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while updating data in NguoiDung table.", e);
        }
    }

    // Xóa người dùng theo ID
    public void delete(int maNguoiDung) throws SQLException {
        String query = "DELETE FROM nguoi_dung WHERE ma_nguoi_dung = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, maNguoiDung);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while deleting data from NguoiDung table.", e);
        }
    }
    
 
}

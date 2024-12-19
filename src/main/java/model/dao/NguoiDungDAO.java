package model.dao;

import model.bean.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private Connection conn;

    public NguoiDungDAO() {
        conn = JDBCUtils.getConnection();  // Kết nối với cơ sở dữ liệu
    }
    
  
    
 // Kiểm tra thông tin đăng nhập
    public boolean checkLogin(String email, String password) throws SQLException {
        String query = "SELECT * FROM nguoi_dung WHERE email = ? AND mat_khau = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public NguoiDung getByEmailAndPassword(String email, String password) throws SQLException {
    	NguoiDung nguoiDung =null;

        String query = "SELECT * FROM nguoi_dung WHERE email = ? AND mat_khau = ?";
        try {
        	PreparedStatement ps = conn.prepareStatement(query);
        	 ps.setString(1, email);
             ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
        	
            while (rs.next()) {
                 nguoiDung = new NguoiDung(
                        rs.getInt("ma_nguoi_dung"),
                        rs.getString("ten_nguoi_dung"),
                        rs.getInt("vai_tro"),
                        rs.getString("mat_khau"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while fetching data from NguoiDung table.", e);
        }
        return nguoiDung;
    }


    // Kiểm tra sự tồn tại của email
    public boolean isEmailExists(String email) throws SQLException {
        String query = "SELECT * FROM nguoi_dung WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    // Thêm người dùng mới
    public void insertUser(NguoiDung nguoiDung) throws SQLException {
        String query = "INSERT INTO nguoi_dung (ten_nguoi_dung,vai_tro, mat_khau, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nguoiDung.getTenNguoiDung());
            ps.setInt(2, nguoiDung.getVaiTro());
            ps.setString(3, nguoiDung.getMatKhau());
            ps.setString(4, nguoiDung.getEmail());
            ps.executeUpdate();
        }
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

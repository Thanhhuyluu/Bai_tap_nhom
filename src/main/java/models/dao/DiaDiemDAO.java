package models.dao;

import models.bean.DiaDiem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiaDiemDAO {
    private Connection conn;

    public DiaDiemDAO() {
        conn = DBConnection.getConnection();  // Kết nối với cơ sở dữ liệu
    }

    // Lấy tất cả địa điểm
    public List<DiaDiem> getAll() throws SQLException {
        List<DiaDiem> list = new ArrayList<>();
        String query = "SELECT * FROM dia_diem";

        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DiaDiem diaDiem = new DiaDiem(
                        rs.getInt("ma_dia_diem"),
                        rs.getInt("ma_khu_vuc"),
                        rs.getString("ten_dia_diem")
                );
                list.add(diaDiem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while fetching data from DiaDiem table.", e);
        }
        return list;
    }

    // Thêm địa điểm mới
    public void insert(DiaDiem diaDiem) throws SQLException {
        String query = "INSERT INTO dia_diem (ma_khu_vuc, ten_dia_diem) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, diaDiem.getMaKhuVuc());
            ps.setString(2, diaDiem.getTenDiaDiem());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while inserting data into DiaDiem table.", e);
        }
    }

    // Cập nhật địa điểm
    public void update(DiaDiem diaDiem) throws SQLException {
        String query = "UPDATE dia_diem SET ma_khu_vuc = ?, ten_dia_diem = ? WHERE ma_dia_diem = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, diaDiem.getMaKhuVuc());
            ps.setString(2, diaDiem.getTenDiaDiem());
            ps.setInt(3, diaDiem.getMaDiaDiem());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while updating data in DiaDiem table.", e);
        }
    }

    // Xóa địa điểm theo ID
    public void delete(int maDiaDiem) throws SQLException {
        String query = "DELETE FROM dia_diem WHERE ma_dia_diem = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, maDiaDiem);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while deleting data from DiaDiem table.", e);
        }
    }
    
    // Kiểm tra sự tồn tại của địa điểm theo tên
    public boolean exists(String tenDiaDiem) throws SQLException {
        String query = "SELECT COUNT(*) FROM dia_diem WHERE ten_dia_diem = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, tenDiaDiem);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Nếu có ít nhất 1 bản ghi, địa điểm tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while checking if DiaDiem exists.", e);
        }
        return false; // Nếu không có bản ghi nào, trả về false
    }
    
    // Tìm kiếm địa điểm theo tên
    public List<DiaDiem> search(String keyword) throws SQLException {
        List<DiaDiem> diaDiems = new ArrayList<>();
        String query = "SELECT * FROM dia_diem WHERE ten_dia_diem LIKE ?";
        
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + keyword + "%"); // Tìm kiếm theo từ khóa
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                DiaDiem diaDiem = new DiaDiem();
                diaDiem.setMaDiaDiem(rs.getInt("ma_dia_diem"));
                diaDiem.setMaKhuVuc(rs.getInt("ma_khu_vuc"));
                diaDiem.setTenDiaDiem(rs.getString("ten_dia_diem"));
                diaDiems.add(diaDiem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error while searching DiaDiem by name.", e);
        }
        return diaDiems; // Trả về danh sách địa điểm tìm được
    }
}

package model.dao;

import model.bean.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChuyenMucDAO {

    // Kết nối cơ sở dữ liệu
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/website_gt_dia_diem_du_lich";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    // Lấy tất cả chuyên mục
    public List<ChuyenMuc> getAll() throws SQLException {
        List<ChuyenMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM chuyen_muc";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChuyenMuc chuyenMuc = new ChuyenMuc(
                    rs.getInt("ma_chuyen_muc"),
                    rs.getInt("ma_bai_dang"),
                    rs.getString("ten_chuyen_muc"),
                    rs.getString("mo_ta"),
                    rs.getString("hinh_anh")
                );
                list.add(chuyenMuc);
            }
        }
        return list;
    }

    // Thêm mới chuyên mục
    public void insert(ChuyenMuc chuyenMuc) throws SQLException {
        String sql = "INSERT INTO chuyen_muc (ma_bai_dang, ten_chuyen_muc, mo_ta, hinh_anh) VALUES (?, ?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, chuyenMuc.getMaBaiDang());
            stmt.setString(2, chuyenMuc.getTenChuyenMuc());
            stmt.setString(3, chuyenMuc.getMoTa());
            stmt.setString(4, chuyenMuc.getHinhAnh());
            stmt.executeUpdate();
        }
    }

    // Cập nhật chuyên mục
    public void update(ChuyenMuc chuyenMuc) throws SQLException {
        String sql = "UPDATE chuyen_muc SET ma_bai_dang = ?, ten_chuyen_muc = ?, mo_ta = ?, hinh_anh = ? WHERE ma_chuyen_muc = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, chuyenMuc.getMaBaiDang());
            stmt.setString(2, chuyenMuc.getTenChuyenMuc());
            stmt.setString(3, chuyenMuc.getMoTa());
            stmt.setString(4, chuyenMuc.getHinhAnh());
            stmt.setInt(5, chuyenMuc.getMaChuyenMuc());
            stmt.executeUpdate();
        }
    }

    // Xóa chuyên mục
    public void delete(int maChuyenMuc) throws SQLException {
        String sql = "DELETE FROM chuyen_muc WHERE ma_chuyen_muc = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maChuyenMuc);
            stmt.executeUpdate();
        }
    }
    
    public List<ChuyenMuc> getAllByMaBaiDang(int maBaiDang) throws SQLException {
        List<ChuyenMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM chuyen_muc WHERE ma_bai_dang = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) { // Tạo PreparedStatement trước
             
            stmt.setInt(1, maBaiDang); // Đặt tham số sau khi stmt đã được khởi tạo
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ChuyenMuc chuyenMuc = new ChuyenMuc(
                        rs.getInt("ma_chuyen_muc"),
                        rs.getInt("ma_bai_dang"),
                        rs.getString("ten_chuyen_muc"),
                        rs.getString("mo_ta"),
                        rs.getString("hinh_anh")
                    );
                    list.add(chuyenMuc);
                }
            }
        }
        return list;
    }

}

package model.dao;

import model.bean.BaiDang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiDangDAO {

    // Kết nối cơ sở dữ liệu
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/website_gt_dia_diem_du_lich"; 
        String user = "root"; 
        String password = ""; 
        return DriverManager.getConnection(url, user, password);
    }

    // Lấy tất cả bài đăng
    public List<BaiDang> getAll() throws SQLException {
        List<BaiDang> list = new ArrayList<>();
        String sql = "SELECT * FROM bai_dang";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	int maBaiDang = rs.getInt("ma_bai_dang");
                String tenBaiDang = rs.getString("ten_bai_dang");
                int maDiaDiem = rs.getInt("ma_dia_diem");
                String moTa = rs.getString("mo_ta_bai_dang");
                int maNguoiDang = rs.getInt("ma_nguoi_dang");
              
                BaiDang baiDang = new BaiDang(maBaiDang, tenBaiDang, maDiaDiem, moTa,maNguoiDang                );
                list.add(baiDang);
            }
        }
        return list;
    }
    
    // Lấy bài đăng theo ID
    public BaiDang getById(int maBaiDang) throws SQLException {
        String sql = "SELECT * FROM bai_dang WHERE ma_bai_dang = ?";
        BaiDang baiDang = null;
        
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maBaiDang);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    baiDang = new BaiDang(
                        rs.getInt("ma_bai_dang"),
                        rs.getString("ten_bai_dang"),
                        rs.getInt("ma_dia_diem"),
                        rs.getString("mo_ta_bai_dang"),
                        rs.getInt("ma_nguoi_dang")
                    );
                }
            }
        }
        return baiDang;
    }


    // Thêm mới bài đăng
    public void insert(BaiDang baiDang) throws SQLException {
        String sql = "INSERT INTO bai_dang (ten_bai_dang, ma_dia_diem, mo_ta_bai_dang, ma_nguoi_dang) VALUES (?, ?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, baiDang.getTenBaiDang());
            stmt.setInt(2, baiDang.getMaDiaDiem());
            stmt.setString(3, baiDang.getMoTaBaiDang());
            stmt.setInt(4, baiDang.getMaNguoiDang());
            stmt.executeUpdate();
        }
    }

    // Cập nhật bài đăng
    public void update(BaiDang baiDang) throws SQLException {
        String sql = "UPDATE bai_dang SET ten_bai_dang = ?, ma_dia_diem = ?, mo_ta_bai_dang = ?, ma_nguoi_dang = ? WHERE ma_bai_dang = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, baiDang.getTenBaiDang());
            stmt.setInt(2, baiDang.getMaDiaDiem());
            stmt.setString(3, baiDang.getMoTaBaiDang());
            stmt.setInt(4, baiDang.getMaNguoiDang());
            stmt.setInt(5, baiDang.getMaBaiDang());
            stmt.executeUpdate();
        }
    }

    // Xóa bài đăng
    public void delete(int maBaiDang) throws SQLException {
        String sql = "DELETE FROM bai_dang WHERE ma_bai_dang = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maBaiDang);
            stmt.executeUpdate();
        }
    }
}

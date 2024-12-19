package model.dao;

import model.bean.BaiDang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiDangDAO {


    // Lấy tất cả bài đăng
    public List<BaiDang> getAll() throws SQLException {
        List<BaiDang> list = new ArrayList<>();
        String sql = "SELECT * FROM bai_dang";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	int maBaiDang = rs.getInt("ma_bai_dang");
                String tenBaiDang = rs.getString("ten_bai_dang");
                int maDiaDiem = rs.getInt("ma_dia_diem");
                String moTa = rs.getString("mo_ta_bai_dang");
                int maNguoiDang = rs.getInt("ma_nguoi_dang");
                String hinhAnh = rs.getString("hinh_anh");
              
                BaiDang baiDang = new BaiDang(maBaiDang, tenBaiDang, maDiaDiem, moTa,maNguoiDang , hinhAnh);
                list.add(baiDang);
            }
        }
        return list;
    }
    
    public List<BaiDang> getBySearch(String search) throws SQLException {
        List<BaiDang> list = new ArrayList<>();
        String sql = "SELECT * FROM bai_dang WHERE ten_bai_dang LIKE ?";
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, "%" + search + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int maBaiDang = rs.getInt("ma_bai_dang");
                    String tenBaiDang = rs.getString("ten_bai_dang");
                    int maDiaDiem = rs.getInt("ma_dia_diem");
                    String moTa = rs.getString("mo_ta_bai_dang");
                    int maNguoiDang = rs.getInt("ma_nguoi_dang");
                    String hinhAnh = rs.getString("hinh_anh");
                  
                    BaiDang baiDang = new BaiDang(maBaiDang, tenBaiDang, maDiaDiem, moTa, maNguoiDang, hinhAnh);
                    list.add(baiDang);
                }
            }
        }
        return list;
    }

    
    
    // Lấy bài đăng theo ID
    public BaiDang getById(int maBaiDang) throws SQLException {
        String sql = "SELECT * FROM bai_dang WHERE ma_bai_dang = ?";
        BaiDang baiDang = null;
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maBaiDang);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    baiDang = new BaiDang(
                        rs.getInt("ma_bai_dang"),
                        rs.getString("ten_bai_dang"),
                        rs.getInt("ma_dia_diem"),
                        rs.getString("mo_ta_bai_dang"),
                        rs.getInt("ma_nguoi_dang"),
                        rs.getString("hinh_anh")
                    );
                }
            }
        }
        return baiDang;
    }


    // Thêm mới bài đăng
    public int insert(BaiDang baiDang) throws SQLException {
        String sql = "INSERT INTO bai_dang (ten_bai_dang, ma_dia_diem, mo_ta_bai_dang, ma_nguoi_dang, hinh_anh) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, baiDang.getTenBaiDang());
            stmt.setInt(2, baiDang.getMaDiaDiem());
            stmt.setString(3, baiDang.getMoTaBaiDang());
            stmt.setInt(4, baiDang.getMaNguoiDang());
            stmt.setString(5,baiDang.getHinhAnh());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int baiDangId = 0;
            if (rs.next()) {
                baiDangId = rs.getInt(1); // Lấy ID tự sinh
            }
            return baiDangId;
        }
    }

    // Cập nhật bài đăng
    public void update(BaiDang baiDang) throws SQLException {
        String sql = "UPDATE bai_dang SET ten_bai_dang = ?, ma_dia_diem = ?, mo_ta_bai_dang = ?, ma_nguoi_dang = ?, hinh_anh = ? WHERE ma_bai_dang = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, baiDang.getTenBaiDang());
            stmt.setInt(2, baiDang.getMaDiaDiem());
            stmt.setString(3, baiDang.getMoTaBaiDang());
            stmt.setInt(4, baiDang.getMaNguoiDang());
            stmt.setString(5, baiDang.getHinhAnh());
            stmt.setInt(6, baiDang.getMaBaiDang());
            stmt.executeUpdate();
        }
    }

    // Xóa bài đăng
    public void delete(int maBaiDang) throws SQLException {
        String sql = "DELETE FROM bai_dang WHERE ma_bai_dang = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maBaiDang);
            stmt.executeUpdate();
        }
    }
}

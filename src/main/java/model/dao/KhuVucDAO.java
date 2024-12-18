package model.dao;

import model.bean.KhuVuc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuVucDAO {

    // Kết nối cơ sở dữ liệu
    private Connection connect() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/website_gt_dia_diem_du_lich"; 
        String user = "root"; 
        String password = ""; 
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }


    public List<KhuVuc> getAll() throws SQLException {
        List<KhuVuc> list = new ArrayList<>();
        String sql = "SELECT * FROM khu_vuc";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	int maBaiDang = rs.getInt("ma_khu_vuc");
                String tenBaiDang = rs.getString("ten_khu_vuc");
              
                KhuVuc khuVuc = new KhuVuc(maBaiDang, tenBaiDang);
                list.add(khuVuc);
            }
        }
        return list;
    }
    

    public KhuVuc getById(int maKhuVuc) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM khu_vuc WHERE ma_khu_vuc = ?";
        KhuVuc khuVuc = null;
        
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maKhuVuc);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    khuVuc = new KhuVuc(
                        rs.getInt("ma_khu_vuc"),
                        rs.getString("ten_khu_vuc")
                    );
                }
            }
        }
        return khuVuc;
    }


    // Thêm mới bài đăng
    public void insert(KhuVuc khuVuc) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO khu_vuc ( ten_khu_vuc) VALUES ( ?)";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, khuVuc.getTenKhuVuc());
            stmt.executeUpdate();
        }
    }

    // Cập nhật bài đăng
    public void update(KhuVuc khuVuc) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE khu_vuc SET ten_khu_vuc = ? WHERE ma_khu_vuc = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, khuVuc.getTenKhuVuc());
            stmt.setInt(2, khuVuc.getMaKhuVuc());
            stmt.executeUpdate();
        }
    }

    // Xóa bài đăng
    public void delete(int maKhuVuc) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM khu_vuc WHERE ma_khu_vuc = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, maKhuVuc);
            stmt.executeUpdate();
        }
    }
}

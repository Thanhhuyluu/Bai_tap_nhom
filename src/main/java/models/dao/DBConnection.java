package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/website_gt_dia_diem_du_lich";
            String user = "root";
            String password = "";  
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

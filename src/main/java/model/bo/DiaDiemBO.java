package model.bo;


import model.bean.*;
import model.dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DiaDiemBO {
	private DiaDiemDAO diaDiemDAO;

    public DiaDiemBO() {
        this.diaDiemDAO = new DiaDiemDAO();
    }

    // Lấy tất cả địa điểm
    public List<DiaDiem> getAllDiaDiem() throws SQLException {
        return diaDiemDAO.getAll();
    }

    // Thêm địa điểm mới
    public void addDiaDiem(DiaDiem diaDiem) throws SQLException {
        diaDiemDAO.insert(diaDiem);
    }

    // Cập nhật địa điểm
    public void updateDiaDiem(DiaDiem diaDiem) throws SQLException {
        diaDiemDAO.update(diaDiem);
    }

    // Xóa địa điểm theo ID
    public void deleteDiaDiem(int maDiaDiem) throws SQLException {
        diaDiemDAO.delete(maDiaDiem);
    }
    
    // Tìm kiếm địa điểm theo tên
    public List<DiaDiem> searchDiaDiem(String keyword) throws SQLException {
        return diaDiemDAO.search(keyword); // Gọi phương thức search từ DAO
    }
    
    // Kiểm tra sự tồn tại của địa điểm trước khi thêm mới
    public boolean checkIfDiaDiemExists(String tenDiaDiem) throws SQLException {
        return diaDiemDAO.exists(tenDiaDiem); 
    }
}

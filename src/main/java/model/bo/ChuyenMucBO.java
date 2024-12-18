package model.bo;

import model.bean.ChuyenMuc;
import model.dao.ChuyenMucDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ChuyenMucBO {
    private ChuyenMucDAO chuyenMucDAO;

    public ChuyenMucBO() {
        this.chuyenMucDAO = new ChuyenMucDAO();
    }

    // Lấy tất cả chuyên mục
    public List<ChuyenMuc> getAllChuyenMuc() throws SQLException {
        return chuyenMucDAO.getAll();
    }

    // Thêm chuyên mục
    public void addChuyenMuc(ChuyenMuc chuyenMuc) throws SQLException {
        chuyenMucDAO.insert(chuyenMuc);
    }

    // Cập nhật chuyên mục
    public void updateChuyenMuc(ChuyenMuc chuyenMuc) throws SQLException {
        chuyenMucDAO.update(chuyenMuc);
    }

    // Xóa chuyên mục
    public void deleteChuyenMuc(int maChuyenMuc) throws SQLException {
        chuyenMucDAO.delete(maChuyenMuc);
    }
}

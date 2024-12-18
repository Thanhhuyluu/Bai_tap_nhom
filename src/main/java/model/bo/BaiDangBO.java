package model.bo;


import model.bean.*;
import model.dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaiDangBO {
    private BaiDangDAO baiDangDAO;

    public BaiDangBO(Connection connection) {
        this.baiDangDAO = new BaiDangDAO();
    }

    public List<BaiDang> getAllBaiDang() throws SQLException {
    	List<BaiDang> listBaiDang = baiDangDAO.getAll();  	
    	return listBaiDang;
    }
    
    public BaiDang getBaiDangByID(int maBaiDang) throws SQLException {
    	return baiDangDAO.getById(maBaiDang);
    }
    
    public void addBaiDang(BaiDang baiDang) throws SQLException {
        baiDangDAO.insert(baiDang);
    }

    public void updateBaiDang(BaiDang baiDang) throws SQLException {
        baiDangDAO.update(baiDang);
    }

    public void deleteBaiDang(int maBaiDang) throws SQLException {
        baiDangDAO.delete(maBaiDang);
    }
}

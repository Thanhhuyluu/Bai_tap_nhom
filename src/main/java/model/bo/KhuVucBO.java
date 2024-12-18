package model.bo;


import model.bean.*;
import model.dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class KhuVucBO {
    private KhuVucDAO khuVucDAO;

    public KhuVucBO() {
        this.khuVucDAO = new KhuVucDAO();
    }

    public List<KhuVuc> getAllKhuVuc() throws SQLException {
    	List<KhuVuc> listKhuVuc = khuVucDAO.getAll();  	
    	return listKhuVuc;
    }
    
    public KhuVuc getKhuVucByID(int maKhuVuc) throws SQLException, ClassNotFoundException {
    	return khuVucDAO.getById(maKhuVuc);
    }
    
    public void addBaiDang(KhuVuc khuVuc) throws SQLException, ClassNotFoundException {
    	khuVucDAO.insert(khuVuc);
    }

    public void updateBaiDang(KhuVuc khuVuc) throws SQLException, ClassNotFoundException {
    	khuVucDAO.update(khuVuc);
    }

    public void deleteBaiDang(int maKhuVuc) throws SQLException, ClassNotFoundException {
    	khuVucDAO.delete(maKhuVuc);
    }
}

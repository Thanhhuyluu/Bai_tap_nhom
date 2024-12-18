package model.bean;

import java.util.List;

public class BaiDang {
	private int maBaiDang;
    private String tenBaiDang;
    private int maDiaDiem;
    private String moTaBaiDang;
    private int maNguoiDang;
    
    
	public BaiDang(int maBaiDang, String tenBaiDang, int maDiaDiem, String moTaBaiDang, int maNguoiDang
			) {
		super();
		this.maBaiDang = maBaiDang;
		this.tenBaiDang = tenBaiDang;
		this.maDiaDiem = maDiaDiem;
		this.moTaBaiDang = moTaBaiDang;
		this.maNguoiDang = maNguoiDang;
	}
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public String getTenBaiDang() {
		return tenBaiDang;
	}
	public void setTenBaiDang(String tenBaiDang) {
		this.tenBaiDang = tenBaiDang;
	}
	public int getMaDiaDiem() {
		return maDiaDiem;
	}
	public void setMaDiaDiem(int maDiaDiem) {
		this.maDiaDiem = maDiaDiem;
	}
	public String getMoTaBaiDang() {
		return moTaBaiDang;
	}
	public void setMoTaBaiDang(String moTaBaiDang) {
		this.moTaBaiDang = moTaBaiDang;
	}
	public int getMaNguoiDang() {
		return maNguoiDang;
	}
	public void setMaNguoiDang(int maNguoiDang) {
		this.maNguoiDang = maNguoiDang;
	}
	
    
}

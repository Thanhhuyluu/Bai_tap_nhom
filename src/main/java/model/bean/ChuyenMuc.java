package model.bean;

public class ChuyenMuc {
	private int maChuyenMuc;
    private int maBaiDang;
    private String tenChuyenMuc;
    private String moTa;
    private String hinhAnh;
    
    public ChuyenMuc(int maChuyenMuc, int maBaiDang, String tenChuyenMuc, String moTa, String hinhAnh) {
        this.maChuyenMuc = maChuyenMuc;
        this.maBaiDang = maBaiDang;
        this.tenChuyenMuc = tenChuyenMuc;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }
    
	public int getMaChuyenMuc() {
		return maChuyenMuc;
	}
	public void setMaChuyenMuc(int maChuyenMuc) {
		this.maChuyenMuc = maChuyenMuc;
	}
	public int getMaBaiDang() {
		return maBaiDang;
	}
	public void setMaBaiDang(int maBaiDang) {
		this.maBaiDang = maBaiDang;
	}
	public String getTenChuyenMuc() {
		return tenChuyenMuc;
	}
	public void setTenChuyenMuc(String tenChuyenMuc) {
		this.tenChuyenMuc = tenChuyenMuc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
}

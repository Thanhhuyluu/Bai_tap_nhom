package models.bean;

public class NguoiDung {
	    private int maNguoiDung;
	    private String tenNguoiDung;
	    private int vaiTro;
	    private String matKhau;
	    private String email;

	    // Constructor
	    public NguoiDung(int maNguoiDung, String tenNguoiDung, int vaiTro, String matKhau, String email) {
	        this.maNguoiDung = maNguoiDung;
	        this.tenNguoiDung = tenNguoiDung;
	        this.vaiTro = vaiTro;
	        this.matKhau = matKhau;
	        this.email = email;
	    }

	    // Getter and Setter
	    public int getMaNguoiDung() {
	        return maNguoiDung;
	    }

	    public void setMaNguoiDung(int maNguoiDung) {
	        this.maNguoiDung = maNguoiDung;
	    }

	    public String getTenNguoiDung() {
	        return tenNguoiDung;
	    }

	    public void setTenNguoiDung(String tenNguoiDung) {
	        this.tenNguoiDung = tenNguoiDung;
	    }

	    public int getVaiTro() {
	        return vaiTro;
	    }

	    public void setVaiTro(int vaiTro) {
	        this.vaiTro = vaiTro;
	    }

	    public String getMatKhau() {
	        return matKhau;
	    }

	    public void setMatKhau(String matKhau) {
	        this.matKhau = matKhau;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
}

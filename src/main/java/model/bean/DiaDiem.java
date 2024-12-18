package model.bean;

public class DiaDiem {
	    private int maDiaDiem;
	    private int maKhuVuc;
	    private String tenDiaDiem;
	    
	 // Constructor mặc định
	    public DiaDiem() {}

	    // Constructor có tham số
	    public DiaDiem(int maDiaDiem, int maKhuVuc, String tenDiaDiem) {
	        this.maDiaDiem = maDiaDiem;
	        this.maKhuVuc = maKhuVuc;
	        this.tenDiaDiem = tenDiaDiem;
	    }

	    // Getter and Setter
	    public int getMaDiaDiem() {
	        return maDiaDiem;
	    }

	    public void setMaDiaDiem(int maDiaDiem) {
	        this.maDiaDiem = maDiaDiem;
	    }

	    public int getMaKhuVuc() {
	        return maKhuVuc;
	    }

	    public void setMaKhuVuc(int maKhuVuc) {
	        this.maKhuVuc = maKhuVuc;
	    }

	    public String getTenDiaDiem() {
	        return tenDiaDiem;
	    }

	    public void setTenDiaDiem(String tenDiaDiem) {
	        this.tenDiaDiem = tenDiaDiem;
	    }
}

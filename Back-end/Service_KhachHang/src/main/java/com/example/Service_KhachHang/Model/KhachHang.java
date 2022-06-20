package com.example.Service_KhachHang.Model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="makh")
	private Integer maKH;
	
	@Column(name="tenkh")
	private String tenKH;
	
	@Column(name="ngaysinh")
	private Date ngaySinh;
	
	@Column(name="sdt")
	private String sdt;
	
	@Column(name="diachi")
	private String diaChi;
	
	@Column(name="email")
	private String email;
	
	@Column(name="cmnd")
	private String cmnd;
	
	@Column(name="maloaikh")
	private Integer maLoaiKH;
	
	@Column(name="taikhoan")
	private Integer taiKhoan;
	
	public KhachHang() {}
	
	public KhachHang (String ten, Date ns, String sdt, String dc, String e, String cmnd, Integer maloaikh, Integer tk)
	{
		this.tenKH = ten;
		this.ngaySinh = ns;
		this.sdt = sdt;
		this.diaChi = dc;
		this.email = e;
		this.cmnd = cmnd;
		this.maLoaiKH = maloaikh;
		this.taiKhoan = tk;
	}
	
	public Integer getMaKH() { return maKH;}
	public void setMaKH(Integer m) { this.maKH = m; }
	
	public String getTenKH() { return tenKH;}
	public void setTenKH(String m) { this.tenKH = m; }
	
	public Date getNgaySinh() { return ngaySinh;}
	public void setNgaySinh(Date m) { this.ngaySinh = m; }
	
	public String getSDT() { return sdt;}
	public void setSDT(String sdt) { this.sdt = sdt; }
	
	public String getDiaChi() { return diaChi;}
	public void setDiaChi(String dc) { this.diaChi = dc; }
	
	public String getEmail() { return email;}
	public void setEmail(String e) { this.email = e; }
	
	public String getCMND() { return cmnd;}
	public void setCMND(String e) { this.cmnd = e; }
	
	public Integer getMaLoaiKH() { return maLoaiKH;}
	public void setTMaLoaiKH(Integer tk) { this.maLoaiKH = tk; }
	
	public Integer getTaiKhoan() { return taiKhoan;}
	public void setTaiKhoan(Integer tk) { this.taiKhoan = tk; }
	
	
}

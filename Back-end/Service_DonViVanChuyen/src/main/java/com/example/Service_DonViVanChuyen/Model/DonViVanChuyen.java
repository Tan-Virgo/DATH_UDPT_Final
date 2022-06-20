package com.example.Service_DonViVanChuyen.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donvivanchuyen")
public class DonViVanChuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="madvvc")
	private Integer maDVVC;

	@Column(name="tendvvc")
	private String tenDVVC;

	@Column(name="giayphepkinhdoanh")
	private String giayPhepKinhDoanh;
	
	@Column(name="sdt")
	private String sdt;
	
	@Column(name="diachi")
	private String diaChi;
	
	@Column(name="email")
	private String email;
	
	@Column(name="sotaikhoannganhang")
	private String soTaiKhoanNganHang;
	
	@Column(name="taikhoan")
	private Integer taiKhoan;
	
	@Column(name="phivanchuyen_km")
	private double phiVanChuyen_KM;
	
	@Column(name="xetduyet")
	private Integer xetDuyet;
	
	public DonViVanChuyen() {}
	
	public DonViVanChuyen(String tendvvc, String giayphepkinhdoanh, String sdt, String diachi, String email, String sotaikhoannganhang, Integer taikhoan, double phivanchuyen_km, Integer xetduyet)
	{
		this.tenDVVC = tendvvc;
		this.giayPhepKinhDoanh = giayphepkinhdoanh;
		this.sdt = sdt;
		this.diaChi = diachi;
		this.email = email;
		this.soTaiKhoanNganHang = sotaikhoannganhang;
		this.taiKhoan = taikhoan;
		this.phiVanChuyen_KM = phivanchuyen_km;
		this.xetDuyet = xetduyet;
	}
	
	public Integer getMaDVVC() { return maDVVC;}
	public void setMaDVVC(Integer madvvc) { this.maDVVC = madvvc; }
	
	public String getTenDVVC() { return tenDVVC;}
	public void setTenDVVC(String tendvvc) { this.tenDVVC = tendvvc; }
	
	public String getGiayPhepKinhDoanh() { return giayPhepKinhDoanh;}
	public void setGiayPhepKinhDoanh(String gpkd) { this.giayPhepKinhDoanh = gpkd; }
	
	public String getSDT() { return sdt;}
	public void setSDT(String sdt) { this.sdt = sdt; }
	
	public String getDiaChi() { return diaChi;}
	public void setDiaChi(String dc) { this.diaChi = dc; }
	
	public String getEmail() { return email;}
	public void setEmail(String e) { this.email = e; }
	
	public String getSoTaiKhoanNganHang() { return soTaiKhoanNganHang;}
	public void setSoTaiKhoanNganHang(String stk) { this.soTaiKhoanNganHang = stk; }
	
	public Integer getTaiKhoan() { return taiKhoan;}
	public void setTaiKhoan(Integer tk) { this.taiKhoan = tk; }
	
	public double getPhiVanChuyen_KM() { return phiVanChuyen_KM;}
	public void setPhiVanChuyen_KM(double tk) { this.phiVanChuyen_KM = tk; }
	
	public Integer getXetDuyet() { return xetDuyet;}
	public void setXetDuyet(Integer xetduyet) { this.xetDuyet = xetduyet; }
}

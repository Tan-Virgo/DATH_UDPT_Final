package com.example.Service_NhaCungCap.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mancc")
	private Integer maNCC;

	@Column(name="tenncc")
	private String tenNCC;

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
	
	@Column(name="xetduyet")
	private Integer xetDuyet;
	
	
	public NhaCungCap() {}
	
	public NhaCungCap(String tenncc, String giayphepkinhdoanh, String sdt, String diachi, String email, String sotaikhoannganhang, Integer taikhoan, Integer xetduyet)
	{
		this.tenNCC = tenncc;
		this.giayPhepKinhDoanh = giayphepkinhdoanh;
		this.sdt = sdt;
		this.diaChi = diachi;
		this.email = email;
		this.soTaiKhoanNganHang = sotaikhoannganhang;
		this.taiKhoan = taikhoan;
		this.xetDuyet = xetduyet;
	}
	
	public Integer getMaNCC() { return maNCC;}
	public void setMaNCC(Integer mancc) { this.maNCC = mancc; }
	
	public String getTenNCC() { return tenNCC;}
	public void setTenNCC(String tenncc) { this.tenNCC = tenncc; }
	
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
	
	public Integer getXetDuyet() { return xetDuyet;}
	public void setXetDuyet(Integer tk) { this.xetDuyet = tk; }
}

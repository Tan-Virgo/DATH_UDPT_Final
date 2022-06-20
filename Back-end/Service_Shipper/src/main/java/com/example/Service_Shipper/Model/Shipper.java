package com.example.Service_Shipper.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipper")
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mashipper")
	private Integer maShipper;

	@Column(name="tenshipper")
	private String tenShipper;
	
	@Column(name="sdt")
	private String sdt;
	
	@Column(name="diachi")
	private String diaChi;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gioitinh")
	private String gioiTinh;
	
	@Column(name="ngaysinh")
	private Date ngaySinh;
	
	@Column(name="cmnd")
	private String cmnd;
	
	@Column(name="madvvc")
	private Integer maDVVC;
	
	@Column(name="taikhoan")
	private Integer taiKhoan;
	
	@Column(name="xetduyet")
	private Integer xetDuyet;
	
	public Shipper() {}
	
	public Shipper(String tenshipper, String sdt, String diachi, String email, String gioitinh, Date ngaysinh, String cmnd, Integer madvvc, Integer taikhoan, Integer xd)
	{
		this.tenShipper = tenshipper;
		this.sdt = sdt;
		this.diaChi = diachi;
		this.email = email;
		this.gioiTinh = gioitinh;
		this.ngaySinh = ngaysinh;
		this.cmnd = cmnd;
		this.maDVVC = madvvc;
		this.taiKhoan = taikhoan;
		this.xetDuyet = xd;
	}
	
	public Integer getMaShipper() { return maShipper;}
	public void setMaShipper(Integer mashipper) { this.maShipper = mashipper; }
	
	public String getTenShipper() { return tenShipper;}
	public void setTenShipper(String tenshipper) { this.tenShipper = tenshipper; }
	
	public String getSDT() { return sdt;}
	public void setSDT(String sdt) { this.sdt = sdt; }
	
	public String getDiaChi() { return diaChi;}
	public void setDiaChi(String dc) { this.diaChi = dc; }
	
	public String getEmail() { return email;}
	public void setEmail(String e) { this.email = e; }
	
	public String getGioiTinh() { return gioiTinh;}
	public void setGioiTinh(String gt) { this.gioiTinh = gt; }
	
	public Date getNgaySinh() { return ngaySinh;}
	public void setNgaySinh(Date ns) { this.ngaySinh = ns; }
	
	public String getCMND() { return cmnd;}
	public void setCMND(String cmnd) { this.cmnd = cmnd; }
	
	public Integer getMaDVVC() { return maDVVC;}
	public void setMaDVVC(Integer madvvc) { this.maDVVC = madvvc; }
	
	public Integer getTaiKhoan() { return taiKhoan;}
	public void setTaiKhoan(Integer tk) { this.taiKhoan = tk; }
	
	public Integer getXetDuyet() { return xetDuyet;}
	public void setXetDuyet(Integer tk) { this.xetDuyet = tk; }
}

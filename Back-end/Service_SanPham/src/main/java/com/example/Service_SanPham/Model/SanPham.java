package com.example.Service_SanPham.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="masp")
	private Integer maSP;
	
	@Column(name="tensp")
	private String tenSP;
	
	@Column(name="donvitinh")
	private String donViTinh;
	
	@Column(name="loaisp")
	private Integer loaiSP;
	
	public SanPham() {}
	
	public SanPham(String tensp, String donvitinh, int loaisp)
	{
		this.tenSP = tensp;
		this.donViTinh = donvitinh;
		this.loaiSP = loaisp;
	}

	public Integer getmaSP() { return maSP;}
	public void setmaSP(Integer masp) { this.maSP = masp; }
	
	public Integer getloaiSP() { return loaiSP;}
	public void setloaiSP(Integer loaisp) { this.loaiSP = loaisp; }
	
	public String gettenSP() { return tenSP;}
	public void settenSP(String tensp) { this.tenSP = tensp; }
	
	public String getdonViTinh() { return donViTinh;}
	public void setdonViTinh(String donvitinh) { this.donViTinh = donvitinh; }
}
package com.example.Service_LichSuMuaHang.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_lichsumuahang")
public class LichSuMuaHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="makh")
	private Integer maKH;
	
	@Column(name="madh")
	private Integer maDH;
	
	@Column(name="tensp")
	private String tenSP;
	
	@Column(name="tenncc")
	private String tenNCC;
	
	@Column(name="nsx")
	private String nhaSanXuat;

	@Column(name="gia")
	private Integer gia;
	
	
	@Column(name="soluong")
	private Integer soLuong;
	
	@Column(name="donvitinh")
	private String donViTinh;
	

	@Column(name="ngaylap")
	private String ngayLap;
	
	@Column(name="hinhthucthanhtoan")
	private String hinhThucThanhToan;
	

	
	@Column(name="tongtien")
	private Integer tongTien;
	


	public LichSuMuaHang() {}
	public LichSuMuaHang(Integer id, Integer makh, Integer madh, String tensp, String tenncc, String donvitinh, String nhasanxuat, Integer gia, Integer soluong, String ngaylap, String hinhthucthanhtoan, Integer tongtien)
	{
		this.id = id;
		this.maKH = makh;
		this.maDH = madh;
		this.tenSP = tensp;
		this.tenNCC = tenncc;
		this.donViTinh = donvitinh;
		this.nhaSanXuat = nhasanxuat;
		this.gia = gia;
		this.soLuong = soluong;
		this.ngayLap = ngaylap;
		this.hinhThucThanhToan = hinhthucthanhtoan;
		this.tongTien = tongtien;
	}
	
	
	public Integer getID() { return id;}
	public void setID(Integer id) { this.id = id; }
	
	public Integer getMaKH() { return maKH;}
	public void setMaKH(Integer mkh) { this.maKH = mkh; }
	
	public Integer getMaDH() { return maDH;}
	public void setMaDH(Integer mdh) { this.maDH = mdh; }
	
	public String getTenSP() { return tenSP;}
	public void setTenSP(String tsp) { this.tenSP = tsp; }
	
	public String getTenNCC() { return tenNCC;}
	public void setTenNCC(String tl) { this.tenNCC = tl; }
	
	
	public String getDonViTinh() { return donViTinh;}
	public void setDonViTinh(String d) { this.donViTinh = d; }
	
	public String getNSX() { return nhaSanXuat;}
	public void setNSX(String nas) { this.nhaSanXuat = nas; }
	
	public Integer getGia() { return gia;}
	public void setGia(Integer g) { this.gia = g; }
	
	public Integer getSoLuong() { return soLuong;}
	public void setSoLuong(Integer sl) { this.soLuong = sl; }
	
	
	public String getNgayLap() { return ngayLap;}
	public void setNgayLap(String nl) { this.ngayLap = nl; }
	
	public String getHinhThucThanhToan() { return hinhThucThanhToan;}
	public void setHinhThucThanhToan(String httt) { this.hinhThucThanhToan = httt; }
	

	
	public Integer getTongTien() { return tongTien;}
	public void setTongTien(Integer tt) { this.tongTien = tt; }
	
}
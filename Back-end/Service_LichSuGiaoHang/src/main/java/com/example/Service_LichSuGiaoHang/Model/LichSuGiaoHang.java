package com.example.Service_LichSuGiaoHang.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_lichsugiaohang")
public class LichSuGiaoHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="madh")
	private Integer maDH;
	
	@Column(name="mashipper")
	private Integer maShipper;
	
	@Column(name="madvvc")
	private Integer maDVVC;
	
	@Column(name="tenkh")
	private String tenKH;
	
	@Column(name="diachi")
	private String diaChi;
	
	
	@Column(name="sdt_khachhang")
	private String sdt;
	
	@Column(name="tenshipper")
	private String tenShipper;
	
	@Column(name="tendvvc")
	private String tenDVVC;
	
	@Column(name="ngaylap")
	private String ngayLap;
	
	@Column(name="trangthai")
	private String trangThai;

	@Column(name="hinhthucthanhtoan")
	private String hinhThucThanhToan;
	
	@Column(name="tongtien")
	private Integer tongTien;

	

	public LichSuGiaoHang() {}
	

	
	public Integer getMaDH() { return maDH;}
	public void setMaDH(Integer mdh) { this.maDH = mdh; }
	
	public Integer getMaShipper() { return maShipper;}
	public void setMaShipper(Integer tsp) { this.maShipper = tsp; }
	
	public Integer getMaDVVC() { return maDVVC;}
	public void setMaDVVC(Integer tsp) { this.maDVVC = tsp; }
	
	public String getTenKH() { return tenKH;}
	public void setTenKH(String tl) { this.tenKH = tl; }
	
	
	public String getDiaChi() { return diaChi;}
	public void setDiaChi(String tl) { this.diaChi = tl; }
	
	public String getSDT() { return sdt;}
	public void setSDT(String sdt) { this.sdt = sdt; }

	public String getTenShipper() { return tenShipper;}
	public void setTenShipper(String ts) { this.tenShipper = ts; }
	
	public String getTenDVVC() { return tenDVVC;}
	public void setTenDVVC(String tl) { this.tenDVVC = tl; }
	
	public String getNgayLap() { return ngayLap;}
	public void setNgayLap(String tl) { this.ngayLap = tl; }
	
	public String getTrangThai() { return trangThai;}
	public void setTrangThai(String ml) { this.trangThai = ml; }
	
	public String getHinhThucThanhToan() { return hinhThucThanhToan;}
	public void setHinhThucThanhToan(String ml) { this.hinhThucThanhToan = ml; }
	
	public Integer getTongTien() { return tongTien;}
	public void setTongTien(Integer ml) { this.tongTien = ml; }
	
}
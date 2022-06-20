package com.example.Service_MatHangBanChay.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_thongke_mathangbanchay")
public class MatHangBanChay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="key")
	private String key;
	
	@Column(name="maloaisp")
	private Integer maLoaiSP;
	
	@Column(name="tenloaisp")
	private String tenLoaiSP;
	
	@Column(name="masp")
	private Integer maSP;
	
	@Column(name="tensp")
	private String tenSP;
	
	@Column(name="mancc")
	private Integer maNCC;
	
	@Column(name="tenncc")
	private String tenNCC;
	
	@Column(name="donvitinh")
	private String donViTinh;
	
	@Column(name="nsx")
	private String nsx;
	
	@Column(name="gia")
	private String gia;
	
	@Column(name="slbanra")
	private Integer slBanRa;
	
	
	public MatHangBanChay() {}
	
	public MatHangBanChay (Integer maloaisp, String tenloaisp, Integer masp, String tensp, Integer mancc, String tenncc, String donvitinh,
			String nsx, String gia, Integer slbanra)
	{
		this.maLoaiSP = maloaisp;
		this.tenLoaiSP = tenloaisp;
		this.maSP = masp;
		this.tenSP = tensp;
		this.maNCC = mancc;
		this.tenNCC = tenncc;
		this.donViTinh = donvitinh;
		this.nsx = nsx;
		this.gia = gia;
		this.slBanRa = slbanra;
	}
	
	public Integer getMaLoaiSP() { return maLoaiSP;}
	public void setMaLoaiSP(Integer ml) { this.maLoaiSP = ml; }
	
	public String getTenLoaiSP() { return tenLoaiSP;}
	public void setTenLoaiSP(String tl) { this.tenLoaiSP = tl; }
	
	public Integer getMaSP() { return maSP;}
	public void setMaSP(Integer ml) { this.maSP = ml; }
	
	public String getTenSP() { return tenSP;}
	public void setTenSP(String tl) { this.tenSP = tl; }
	
	public Integer getMaNCC() { return maNCC;}
	public void setMaNCC(Integer ml) { this.maNCC = ml; }
	
	public String getTenNCC() { return tenNCC;}
	public void setTenNCC(String tl) { this.tenNCC = tl; }
	
	public String getDonViTinh() { return donViTinh;}
	public void setDonViTinh(String tl) { this.donViTinh = tl; }
	
	public String getNS() { return nsx;}
	public void setNSX(String tl) { this.nsx = tl; }
	
	public String getGia() { return gia;}
	public void setGia(String tl) { this.gia = tl; }
	
	public Integer getSLBanRa() { return slBanRa;}
	public void setSLBanRa(Integer ml) { this.slBanRa = ml; }
}

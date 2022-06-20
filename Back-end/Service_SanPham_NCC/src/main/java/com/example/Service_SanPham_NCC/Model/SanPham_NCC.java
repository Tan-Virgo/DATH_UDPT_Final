package com.example.Service_SanPham_NCC.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_sanpham_ncc")
public class SanPham_NCC {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="mancc")
	private Integer maNCC;
	
	@Column(name="masp")
	private Integer maSP;
	
	@Column(name="tensp")
	private String tenSP;
	
	@Column(name="donvitinh")
	private String donViTinh;
	
	@Column(name="nsx")
	private String nsx;
	
	@Column(name="gia")
	private String gia;
	
	@Column(name="url")
	private String url;

	
	public SanPham_NCC() {}
	
	public SanPham_NCC(Integer mancc, Integer masp, String tensp, String donvitinh, String nsx, String gia, String url)
	{
		this.maNCC = mancc;
		this.maSP = masp;
		this.tenSP = tensp;
		this.donViTinh = donvitinh;
		this.nsx = nsx;
		this.gia = gia;
		this.url = url;
	}
	
	public Integer getID() { return id;}
	
	public Integer getMaNCC() { return maNCC;}
	public void setMaNCC(Integer mancc) { this.maNCC = mancc; }

	public Integer getMasp() { return maSP;}
	public void setMasp(Integer masp) { this.maSP = masp; }
	
	public String getTenSP() { return tenSP;}
	public void setTenSP(String tensp) { this.tenSP = tensp; }
	
	public String getDonViTinh() { return donViTinh;}
	public void setTenDonViTinh(String dvt) { this.donViTinh = dvt; }
	
	public String getNSX() { return nsx;}
	public void setNSX(String n) { this.nsx = n; }
	
	public String getGia() { return gia;}
	public void setGia(String gia) { this.gia = gia; }
	
	public String getUrl() { return url;}
	public void setUrl(String uRL) { this.url = uRL; }

}

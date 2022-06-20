package com.example.Service_NhuCauCungKy.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_thongke_cungky")
public class NhuCauCungKy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nam")
	private Integer nam;
	
	@Column(name="quy")
	private Integer quy;
	
	@Column(name="thang")
	private Integer thang;
	
	@Column(name="masp")
	private Integer maSP;
	
	@Column(name="tensp")
	private String tenSP;
	
	@Column(name="donvitinh")
	private String donViTinh;
	
	@Column(name="slbanra")
	private Integer slBanRa;
	
	public NhuCauCungKy() {}
	
	public Integer getNam() { return nam;}
	public void setNam(Integer n) { this.nam = n; }
	
	public Integer getQuy() { return quy;}
	public void setQuy(Integer n) { this.quy = n; }
	
	public Integer getThang() { return thang;}
	public void setThang(Integer n) { this.thang = n; }
	
	public Integer getMaSP() { return maSP;}
	public void setMaSP(Integer n) { this.maSP = n; }
	
	public String getTenSP() { return tenSP;}
	public void setTenSP(String n) { this.tenSP = n; }
	
	public String getDonViTinh() { return donViTinh;}
	public void setDonViTinh(String n) { this.donViTinh = n; }
	
	public Integer getSLBanRa() { return slBanRa;}
	public void setSLBanRa(Integer n) { this.slBanRa = n; }
}

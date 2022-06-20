package com.example.Service_ThongKe_DoanhThu.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_thongke_doanhthu_ncc")
public class ThongKe_DoanhThu {
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
	
	@Column(name="mancc")
	private Integer maNCC;
	
	@Column(name="tenncc")
	private String tenNCC;

	@Column(name="doanhthu")
	private double doanhThu;
	
	public ThongKe_DoanhThu() {}
	
	public Integer getNam() { return nam;}
	public void setNam(Integer n) { this.nam = n; }
	
	public Integer getQuy() { return quy;}
	public void setQuy(Integer n) { this.quy = n; }
	
	public Integer getThang() { return thang;}
	public void setThang(Integer n) { this.thang = n; }
	
	public Integer getMaNCC() { return maNCC;}
	public void setMaNCC(Integer n) { this.maNCC = n; }
	
	public String getTenNCC() { return tenNCC;}
	public void setTenNCC(String n) { this.tenNCC = n; }
	
	public double getDoanhThu() { return doanhThu;}
	public void setDoanhThu(double n) { this.doanhThu = n; }
}

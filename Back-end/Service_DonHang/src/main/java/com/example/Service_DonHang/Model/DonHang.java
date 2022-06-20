package com.example.Service_DonHang.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donhang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="madh")
	private Integer maDH;
	
	@Column(name="makh")
	private Integer maKH;
	
	@Column(name="mashipper")
	private Integer maShipper;
	
	@Column(name="trangthai")
	private String trangThai;
	
	@Column(name="hinhthucthanhtoan")
	private String hinhThucThanhToan;
	
	@Column(name="tongtien")
	private float tongTien;
	
	@Column(name="ngaylap")
	private Date ngayLap;
	
	public DonHang() {}
	
	public DonHang(int makh, int mas, String trangthai, String httt, float tongtien, Date ngaylap)
	{
		this.maShipper = mas;
		this.maKH = makh;
		this.trangThai = trangthai;
		this.tongTien = tongtien;
		this.ngayLap = ngaylap;
		this.hinhThucThanhToan = httt;
	}
	
	public Integer getmaDH() { return maDH;}
	public void setmaDH(Integer madh) { this.maDH = madh; }
	
	public Integer getmaKH() { return maKH;}
	public void setmaKH(Integer makh) { this.maKH = makh; }

	public Integer getmaS() { return maShipper;}
	public void setmaS(Integer mas) { this.maShipper = mas; }
	
	public Date getngayLap() { return ngayLap;}
	public void setngayLap(Date ngaylap) { this.ngayLap = ngaylap; }
	
	public String gettrangThai() { return trangThai;}
	public void settrangThai(String trangthai) { this.trangThai = trangthai; }
	
	public float gettongTien() { return tongTien;}
	public void settongTien(float tongtien) { this.tongTien = tongtien; }
	
	public String getHTTT() { return hinhThucThanhToan;}
	public void setHTTT(String httt) { this.hinhThucThanhToan = httt; }
}
	

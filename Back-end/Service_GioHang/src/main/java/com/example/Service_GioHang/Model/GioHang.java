package com.example.Service_GioHang.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="giohang")
public class GioHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="magh")
	private Integer maGH;
	
	@Column(name="makh")
	private Integer maKH;
	
	@Column(name="masp")
	private Integer maSP;
	
	@Column(name="tensp")
	private String tenSP;
	
	@Column(name="soluong")
	private float soLuong;
	
	@Column(name="gia")
	private float gia;
	
	public GioHang() {}
	
	public GioHang(int makh, int masp, String tensp, float soluong, float Gia)
	{
		this.tenSP = tensp;
		this.maKH = makh;
		this.maSP = masp;
		this.soLuong = soluong;
		this.gia = Gia;
	}

	public Integer getmaGH() { return maGH;}
	public void setmaGH(Integer magh) { this.maGH = magh; }
	
	public Integer getmaKH() { return maKH;}
	public void setmaKH(Integer makh) { this.maKH = makh; }
	
	public Integer getmaSP() { return maSP;}
	public void setmaSP(Integer masp) { this.maSP = masp; }
	
	public String gettenSP() { return tenSP;}
	public void settenSP(String tensp) { this.tenSP = tensp; }
	
	public float getsoLuong() { return soLuong;}
	public void setsoLuong(float soluong) { this.soLuong = soluong; }
	
	public float getGia() { return gia;}
	public void setGia(float Gia) { this.gia = Gia; }
}
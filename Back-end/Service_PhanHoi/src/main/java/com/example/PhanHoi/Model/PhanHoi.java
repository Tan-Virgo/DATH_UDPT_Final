package com.example.PhanHoi.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phanhoi")
public class PhanHoi {
	@Column(name = "maphanhoi")
	@Id
	private int maphanhoi;

	@Column(name = "chitiet")
	private String chitiet;

	@Column(name = "ngaytao")
	private Date ngaytao;

	@Column(name = "nguoidung")
	private int nguoidung;

	@Column(name = "sanpham")
	private int sanpham;

	@Column(name = "nhacungcap")
	private int nhacungcap;
	
	
	public PhanHoi () {}
	public PhanHoi (String ct, Date ngay, int kh, int sp, int ncc) 
	{
		this.chitiet = ct;
		this.ngaytao = ngay;
		this.nguoidung = kh;
		this.sanpham = sp;
		this.nhacungcap = ncc;
	}
	

	/**
	 * @return the chitiet
	 */
	public String getChitiet() {
		return chitiet;
	}

	/**
	 * @param chitiet the chitiet to set
	 */
	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}

	/**
	 * @return the ngaytao
	 */
	public Date getNgaytao() {
		return ngaytao;
	}

	/**
	 * @param ngaytao the ngaytao to set
	 */
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	/**
	 * @return the nguoidung
	 */
	public int getNguoidung() {
		return nguoidung;
	}

	/**
	 * @param nguoidung the nguoidung to set
	 */
	public void setNguoidung(int nguoidung) {
		this.nguoidung = nguoidung;
	}

	/**
	 * @return the sanpham
	 */
	public int getSanpham() {
		return sanpham;
	}

	/**
	 * @param sanpham the sanpham to set
	 */
	public void setSanpham(int sanpham) {
		this.sanpham = sanpham;
	}

	/**
	 * @return the nhacungcap
	 */
	public int getNhacungcap() {
		return nhacungcap;
	}

	/**
	 * @param nhacungcap the nhacungcap to set
	 */
	public void setNhacungcap(int nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	/**
	 * @return the maphanhoi
	 */
	public int getMaphanhoi() {
		return maphanhoi;
	}

	/**
	 * @param maphanhoi the maphanhoi to set
	 */
	public void setMaphanhoi(int maphanhoi) {
		this.maphanhoi = maphanhoi;
	}
}
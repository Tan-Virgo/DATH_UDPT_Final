package com.example.Service_TaiKhoan.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taikhoan")

public class TaiKhoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String passWord;
	
	@Column(name="trangthai")
	private String trangThai;
	
	@Column(name="vaitro")
	private String vaiTro;
	
	public TaiKhoan () {}
	
	public TaiKhoan (String username, String password, String trangthai, String vaitro)
	{
		this.userName = username;
		this.passWord = password;
		this.trangThai = trangthai;
		this.vaiTro = vaitro;
	}
	
	public Integer getID() { return id;}
	public void setID(Integer u) { this.id = u; }
	
	public String getUsername() { return userName;}
	public void setUsername(String u) { this.userName = u; }
	
	public String getPassword() { return passWord;}
	public void setPassword(String u) { this.passWord = u; }
	
	public String getTrangThai() { return trangThai;}
	public void setTrangThai(String u) { this.trangThai = u; }
	
	public String getVaiTro() { return vaiTro;}
	public void setVaiTro(String u) { this.vaiTro = u; }
}

package com.example.Service_KhachHang.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_KhachHang.Repository.KhachHangRepository;
import com.example.Service_KhachHang.Model.KhachHang;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class KhachHangController {
	@Autowired
	private KhachHangRepository khRepository;
	
	@GetMapping("/dskhachhang")
	public ResponseEntity<List<KhachHang>> layDSDonViVanChuyen()
	{
		List<KhachHang> dvvc = new ArrayList<KhachHang>();
		
		try
		{	
			khRepository.findAll().forEach(dvvc::add);
			
			if(dvvc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dvvc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/khachhang/{makh}")
	public ResponseEntity<Optional<KhachHang>> layKH(@PathVariable("makh") Integer makh)
	{
		
		try
		{	
			Optional<KhachHang> dvvc = khRepository.findByMaKH(makh);
			
			if(dvvc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dvvc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/khachhang_taikhoan/{taikhoan}")
	public ResponseEntity<Optional<KhachHang>> layKHbytk(@PathVariable("taikhoan") Integer taikhoan)
	{
		
		try
		{	
			Optional<KhachHang> dvvc = khRepository.findByTaiKhoan(taikhoan);
			
			if(dvvc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dvvc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package com.example.Service_LichSuMuaHang.Controller;

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


import com.example.Service_LichSuMuaHang.Repository.LichSuMuaHangRepository;
import com.example.Service_LichSuMuaHang.Model.LichSuMuaHang;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class LichSuMuaHangController {
	@Autowired
	private LichSuMuaHangRepository lsmuahangRepository;
	
	@GetMapping("/lichsumuahang")
	public ResponseEntity<List<LichSuMuaHang>> layDSLichSuMuaHang()
	{
		List<LichSuMuaHang> mhbc = new ArrayList<LichSuMuaHang>();
		
		try
		{
			lsmuahangRepository.findAll().forEach(mhbc::add);
			
			if(mhbc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(mhbc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/lichsumuahang/{makh}")
	public ResponseEntity<List<LichSuMuaHang>> layDSDonHangKH(@PathVariable("makh") Integer makh)
	{
		List<LichSuMuaHang> mhbc = new ArrayList<LichSuMuaHang>();
		
		try
		{
			lsmuahangRepository.findByMaKH(makh).forEach(mhbc::add);
			
			if(mhbc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(mhbc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
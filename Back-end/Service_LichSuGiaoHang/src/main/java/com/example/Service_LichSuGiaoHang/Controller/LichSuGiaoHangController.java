package com.example.Service_LichSuGiaoHang.Controller;

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


import com.example.Service_LichSuGiaoHang.Repository.LichSuGiaoHangRepository;
import com.example.Service_LichSuGiaoHang.Model.LichSuGiaoHang;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class LichSuGiaoHangController {
	@Autowired
	private LichSuGiaoHangRepository lsgiaohangRepository;
	
	@GetMapping("/lichsugiaohang")
	public ResponseEntity<List<LichSuGiaoHang>> layDSLichSuGiaoHang()
	{
		List<LichSuGiaoHang> mhbc = new ArrayList<LichSuGiaoHang>();
		
		try
		{
			lsgiaohangRepository.findAll().forEach(mhbc::add);
			
			if(mhbc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(mhbc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/lichsugiaohang/{madvvc}")
	public ResponseEntity<List<LichSuGiaoHang>> layDonViVanChuyen(@PathVariable("madvvc") Integer madvvc)
	{
		
		List<LichSuGiaoHang> mhbc = new ArrayList<LichSuGiaoHang>();
		
		try
		{
			lsgiaohangRepository.findByMaDVVC(madvvc).forEach(mhbc::add);
			
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
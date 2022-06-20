package com.example.Service_GioHang.Controller;

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

import com.example.Service_GioHang.Model.GioHang;
import com.example.Service_GioHang.Repository.GioHangRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class GioHangController {
	@Autowired
	private GioHangRepository giohangRepository;
	
	@GetMapping("/dsgh")
	public ResponseEntity<List<GioHang>> layDSGH()
	{
		List<GioHang> giohang = new ArrayList<GioHang>();
		
		try
		{	
			giohangRepository.findAll().forEach(giohang::add);

			if(giohang.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(giohang, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/giohang/{makh}")
	public ResponseEntity<List<GioHang>> layGH(@PathVariable("makh") Integer makh)
	{
		List<GioHang> giohang = new ArrayList<GioHang>();
		
		try
		{	
			giohang.addAll(giohangRepository.findByMaKH(makh));

			if(giohang.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(giohang, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/giohang")
	public ResponseEntity<GioHang> themSPGH(@RequestBody GioHang s)
	{
		try
		{
			GioHang _s = giohangRepository.save(new GioHang(s.getmaSP(), s.getmaKH(), s.gettenSP(), s.getsoLuong(), s.getGia()));
			return new ResponseEntity<>(_s, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/giohang/{magh}")
	public ResponseEntity<GioHang> capNhatSPGH(@PathVariable("magh") Integer magh, @RequestBody GioHang s)
	{
		Optional<GioHang> sData = giohangRepository.findById(magh);
		
		if (sData.isPresent())
		{
			GioHang _s = sData.get();
			_s.setsoLuong(s.getsoLuong());
			_s.setGia(s.getGia());
			_s.setmaSP(s.getmaSP());
			_s.settenSP(s.gettenSP());
			_s.setmaKH(s.getmaKH());
			
			return new ResponseEntity<>(giohangRepository.save(_s), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/giohang/{magh}")
	public ResponseEntity<HttpStatus> xoaMotSPGH(@PathVariable("magh") Integer magh) 
	{
		try 
		{
			giohangRepository.deleteById(magh);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/alldeletespgh")
	public ResponseEntity<HttpStatus> xoaTatCaSPGH(@PathVariable("makh") Integer makh) 
	{
		List<GioHang> giohang = new ArrayList<GioHang>();
		List<GioHang> giohangkh = new ArrayList<GioHang>();
		try 
		{
			giohangRepository.findAll().forEach(giohang::add);
			giohangkh.addAll(giohangRepository.findByMaKH(makh));
			giohang.removeAll(giohangkh);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

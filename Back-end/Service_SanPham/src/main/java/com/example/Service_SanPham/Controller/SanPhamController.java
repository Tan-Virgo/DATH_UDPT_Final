package com.example.Service_SanPham.Controller;

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

import com.example.Service_SanPham.Model.SanPham;
import com.example.Service_SanPham.Repository.SanPhamRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class SanPhamController {
	@Autowired
	private SanPhamRepository sanphamRepository;
	
	@GetMapping("/dssp")
	public ResponseEntity<List<SanPham>> layDSSP()
	{
		List<SanPham> sanpham = new ArrayList<SanPham>();
		
		try
		{	
			sanphamRepository.findAll().forEach(sanpham::add);

			if(sanpham.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(sanpham, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/sanpham")
	public ResponseEntity<SanPham> themSP(@RequestBody SanPham s)
	{
		try
		{
			SanPham _s = sanphamRepository.save(new SanPham(s.gettenSP(), s.getdonViTinh(), s.getloaiSP()));
			return new ResponseEntity<>(_s, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sanpham/{masp}")
	public ResponseEntity<SanPham> capNhatSP(@PathVariable("masp") Integer masp, @RequestBody SanPham s)
	{
		Optional<SanPham> sData = sanphamRepository.findByMaSP(masp);
		
		if (sData.isPresent())
		{
			SanPham _s = sData.get();
			_s.settenSP(s.gettenSP());
			_s.setdonViTinh(s.getdonViTinh());
			_s.setloaiSP(s.getloaiSP());
			
			return new ResponseEntity<>(sanphamRepository.save(_s), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/sanpham/{masp}")
	public ResponseEntity<HttpStatus> xoaMotSP(@PathVariable("masp") Integer masp) 
	{
		try 
		{
			sanphamRepository.deleteById(masp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/alldeletesp")
	public ResponseEntity<HttpStatus> xoaTatCaShipper() 
	{
		try 
		{
			sanphamRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


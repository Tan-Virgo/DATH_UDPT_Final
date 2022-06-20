package com.example.Service_TaiKhoan.Controller;

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

import com.example.Service_TaiKhoan.Repository.TaiKhoanRepository;
import com.example.Service_TaiKhoan.Model.TaiKhoan;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")

public class TaiKhoanController {
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	
	
	@GetMapping("/dstaikhoan")
	public ResponseEntity<List<TaiKhoan>> layDSTaiKhoan()
	{
		List<TaiKhoan> tk = new ArrayList<TaiKhoan>();
		
		try
		{	
			taiKhoanRepository.findAll().forEach(tk::add);
			
			if(tk.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(tk, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping("/taikhoan/{username}")
	public ResponseEntity<Optional<TaiKhoan>> layTaiKhoan(@PathVariable("username") String username)
	{	
		try
		{	
			Optional<TaiKhoan> tkData = taiKhoanRepository.findByUserName(username);
			
			if(tkData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(tkData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/taikhoan")
	public ResponseEntity<TaiKhoan> themTaiKhoan(@RequestBody TaiKhoan tk)
	{
		try
		{
			TaiKhoan _tk = taiKhoanRepository.save(new TaiKhoan(tk.getUsername(), tk.getPassword(), tk.getTrangThai(), tk.getVaiTro()));
			return new ResponseEntity<>(_tk, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/taikhoan/{username}")
	public ResponseEntity<TaiKhoan> capNhatTaiKhoan(@PathVariable("username") String username,
			@RequestBody TaiKhoan tk)
	{
		Optional<TaiKhoan> tkData = taiKhoanRepository.findByUserName(username);
		
		if (tkData.isPresent())
		{
			TaiKhoan _tk = tkData.get();
			_tk.setUsername(tk.getUsername());
			_tk.setPassword(tk.getPassword());
			_tk.setTrangThai(tk.getTrangThai());
			_tk.setVaiTro(tk.getVaiTro());
			
			return new ResponseEntity<>(taiKhoanRepository.save(_tk), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping("/taikhoan/{username}")
	public ResponseEntity<HttpStatus> xoaMotTaiKhoan(@PathVariable("username") String username)
	{
		try 
		{
			Optional<TaiKhoan> tkData = taiKhoanRepository.findByUserName(username);
			
			if (tkData.isPresent())
			{
				TaiKhoan _tk = tkData.get();
				
				Integer id = _tk.getID();
				
				taiKhoanRepository.deleteById(id);
			}
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

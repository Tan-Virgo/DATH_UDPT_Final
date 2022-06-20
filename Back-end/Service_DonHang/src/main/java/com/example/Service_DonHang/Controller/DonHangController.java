package com.example.Service_DonHang.Controller;

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

import com.example.Service_DonHang.Model.DonHang;
import com.example.Service_DonHang.Repository.DonHangRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class DonHangController {
	@Autowired
	private DonHangRepository donhangRepository;
	
	@GetMapping("/donhang")
	public ResponseEntity<List<DonHang>> layDH()
	{
		List<DonHang> donhang = new ArrayList<DonHang>();
		
		try
		{	
			donhangRepository.findAll().forEach(donhang::add);

			if(donhang.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(donhang, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/donhang/{madh}")
	public ResponseEntity<DonHang> layDSDonHang(@PathVariable("madh") Integer madh)
	{
		try
		{
			Optional<DonHang> dhData = donhangRepository.findByMaDH(madh);
			
			return new ResponseEntity<>(dhData.get(), HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	@GetMapping("/dsdonhang")
	public ResponseEntity<List<DonHang>> layDSDonHang()
	{
		List<DonHang> dh = new ArrayList<DonHang>();
		
		try
		{	
			donhangRepository.findAll().forEach(dh::add);
			
			if(dh.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dh, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/donhang_kh/{makh}")
	public ResponseEntity<List<DonHang>> layDHKH(@PathVariable("makh") Integer makh)
	{
		List<DonHang> donhang = new ArrayList<DonHang>();
		
		try
		{	
			donhang.addAll(donhangRepository.findByMaKH(makh));

			if(donhang.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(donhang, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/donhang")
	public ResponseEntity<DonHang> themDonHang(@RequestBody DonHang dh)
	{
		try
		{
			DonHang _dh = donhangRepository.save(new DonHang(dh.getmaDH(), 
					dh.getmaS(),
					dh.gettrangThai(),
					dh.getHTTT(),
					dh.gettongTien(),
					dh.getngayLap()
					));
			return new ResponseEntity<>(_dh, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/donhang/{madh}")
	public ResponseEntity<DonHang> capNhatDonHang(@PathVariable("madh") Integer madh, @RequestBody DonHang dh)
	{
		Optional<DonHang> dhData = donhangRepository.findByMaDH(madh);
		
		if (dhData.isPresent())
		{
			DonHang _dh = dhData.get();
			_dh.setmaDH(dh.getmaDH());
			_dh.setngayLap(dh.getngayLap());
			_dh.settongTien(dh.gettongTien());
			_dh.settrangThai(dh.gettrangThai());
			_dh.setmaKH(dh.getmaKH());
			_dh.setHTTT(dh.getHTTT());
			_dh.setmaS(dh.getmaS());
			
			return new ResponseEntity<>(donhangRepository.save(_dh), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/donhang/{madh}")
	public ResponseEntity<HttpStatus> xoaMotDonHang(@PathVariable("madh") Integer madh) 
	{
		try 
		{
			donhangRepository.deleteById(madh);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/alldeletedonhang")
	public ResponseEntity<HttpStatus> xoaTatCaDonHang() 
	{
		try 
		{
			donhangRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

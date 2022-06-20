package com.example.Service_Shipper.Controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import  com.example.Service_Shipper.Repository.ShipperRepository;
import  com.example.Service_Shipper.Model.Shipper;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class ShipperController {
	@Autowired
	private ShipperRepository shipperRepository;
	
	@GetMapping("/dsshipper")
	public ResponseEntity<List<Shipper>> layDSShipper()
	{
		List<Shipper> shipper = new ArrayList<Shipper>();
		
		try
		{	
			shipperRepository.findAll().forEach(shipper::add);

			if(shipper.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(shipper, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/dsshipper/{madvvc}")
	public ResponseEntity<List<Shipper>> layDSShipper(@PathVariable("madvvc") Integer madvvc)
	{
		List<Shipper> shipper = new ArrayList<Shipper>();
		
		try
		{	
			shipperRepository.findByMaDVVC(madvvc).forEach(shipper::add);

			if(shipper.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(shipper, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/shipper/{mashipper}")
	public ResponseEntity<Optional<Shipper>> layShipper(@PathVariable("mashipper") Integer mashipper)
	{
		try
		{	
			Optional<Shipper> sData = shipperRepository.findByMaShipper(mashipper);
			if(sData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(sData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//@CrossOrigin(origins = "http://localhost:2082/UDPT_ChoOnline")
	//@PostMapping("/shipper", produces = MediaType.APPLICATION_JSON_UTF8, consumes = MediaType.APPLICATION_JSON_UTF8)
	@RequestMapping(value = "/shipper", method = RequestMethod.POST)
	public ResponseEntity<Shipper> themShipper(@RequestBody Shipper s)
	{
		try
		{
			Shipper _s = shipperRepository.save(new Shipper(s.getTenShipper(), s.getSDT(), s.getDiaChi(), s.getEmail(),
					s.getGioiTinh(), s.getNgaySinh(), s.getCMND(), s.getMaDVVC(), s.getTaiKhoan(), s.getXetDuyet()));
			return new ResponseEntity<>(_s, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/shipper/{mashipper}")
	public ResponseEntity<Shipper> capNhatShipper(@PathVariable("mashipper") Integer mashipper, @RequestBody Shipper s)
	{
		Optional<Shipper> sData = shipperRepository.findByMaShipper(mashipper);
		
		if (sData.isPresent())
		{
			Shipper _s = sData.get();
			_s.setTenShipper(s.getTenShipper());
			_s.setEmail(s.getEmail());
			_s.setDiaChi(s.getDiaChi());
			_s.setSDT(s.getSDT());
			_s.setTaiKhoan(s.getTaiKhoan());
			_s.setGioiTinh(s.getGioiTinh());
			_s.setNgaySinh(s.getNgaySinh());
			_s.setCMND(s.getCMND());
			_s.setMaDVVC(s.getMaDVVC());
			_s.setXetDuyet(s.getXetDuyet());
			return new ResponseEntity<>(shipperRepository.save(_s), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/shipper/{mashipper}")
	public ResponseEntity<HttpStatus> xoaMotShipper(@PathVariable("mashipper") Integer mashipper) 
	{
		try 
		{
			shipperRepository.deleteById(mashipper);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/alldeleteshipper")
	public ResponseEntity<HttpStatus> xoaTatCaShipper() 
	{
		try 
		{
			shipperRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

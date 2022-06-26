package com.example.Service_DonViVanChuyen.Controller;

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

import com.example.Service_DonViVanChuyen.Repository.DonViVanChuyenRepository;
import com.example.Service_DonViVanChuyen.Model.DonViVanChuyen;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class DonViVanChuyenController {
	@Autowired
	private DonViVanChuyenRepository donViVanChuyenRepository;
	
	@GetMapping("/dsdonvivanchuyen")
	public ResponseEntity<List<DonViVanChuyen>> layDSDonViVanChuyen()
	{
		List<DonViVanChuyen> dvvc = new ArrayList<DonViVanChuyen>();
		
		try
		{	
			donViVanChuyenRepository.findAll().forEach(dvvc::add);
			
			if(dvvc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dvvc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/donvivanchuyen/{madvvc}")
	public ResponseEntity<Optional<DonViVanChuyen>> layDonViVanChuyen(@PathVariable("madvvc") Integer madvvc)
	{
		
		try
		{	
			Optional<DonViVanChuyen> dvvc = donViVanChuyenRepository.findByMaDVVC(madvvc);
			
			if(dvvc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dvvc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/donvivanchuyen_taikhoan/{taikhoan}")
	public ResponseEntity<Optional<DonViVanChuyen>> layDonViVanChuyenByTaiKhoan(@PathVariable("taikhoan") Integer taikhoan)
	{
		
		try
		{	
			Optional<DonViVanChuyen> dvvc = donViVanChuyenRepository.findByTaiKhoan(taikhoan);
			
			if(dvvc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(dvvc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/donvivanchuyen")
	public ResponseEntity<DonViVanChuyen> themDonViVanChuyen(@RequestBody DonViVanChuyen dvvc)
	{
		try
		{
			DonViVanChuyen _dvvc = donViVanChuyenRepository.save(new DonViVanChuyen(dvvc.getTenDVVC(), dvvc.getGiayPhepKinhDoanh(),
					dvvc.getSDT(), dvvc.getDiaChi(), dvvc.getEmail(), dvvc.getSoTaiKhoanNganHang(), dvvc.getTaiKhoan(), dvvc.getPhiVanChuyen_KM(), dvvc.getXetDuyet()));
			return new ResponseEntity<>(_dvvc, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/donvivanchuyen/{madvvc}")
	public ResponseEntity<DonViVanChuyen> capNhatDonViVanChuyen(@PathVariable("madvvc") Integer madvvc, @RequestBody DonViVanChuyen dvvc)
	{
		Optional<DonViVanChuyen> dvvcData = donViVanChuyenRepository.findByMaDVVC(madvvc);
		
		if (dvvcData.isPresent())
		{
			DonViVanChuyen _dvvc = dvvcData.get();
			_dvvc.setTenDVVC(dvvc.getTenDVVC());
			_dvvc.setGiayPhepKinhDoanh(dvvc.getGiayPhepKinhDoanh());
			_dvvc.setEmail(dvvc.getEmail());
			_dvvc.setDiaChi(dvvc.getDiaChi());
			_dvvc.setSDT(dvvc.getSDT());
			_dvvc.setSoTaiKhoanNganHang(dvvc.getSoTaiKhoanNganHang());
			_dvvc.setTaiKhoan(dvvc.getTaiKhoan());
			_dvvc.setPhiVanChuyen_KM(dvvc.getPhiVanChuyen_KM());
			_dvvc.setXetDuyet(dvvc.getXetDuyet());
			
			return new ResponseEntity<>(donViVanChuyenRepository.save(_dvvc), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/donvivanchuyen/{madvvc}")
	public ResponseEntity<HttpStatus> xoaMotDonViVanChuyen(@PathVariable("madvvc") Integer madvvc) 
	{
		try 
		{
			donViVanChuyenRepository.deleteById(madvvc);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/alldeletedonvivanchuyen")
	public ResponseEntity<HttpStatus> xoaTatCaDonViVanChuyen() 
	{
		try 
		{
			donViVanChuyenRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

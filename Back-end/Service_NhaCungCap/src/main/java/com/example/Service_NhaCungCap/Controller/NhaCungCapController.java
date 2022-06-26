package com.example.Service_NhaCungCap.Controller;

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

import com.example.Service_NhaCungCap.Repository.NhaCungCapRepository;
import com.example.Service_NhaCungCap.Model.NhaCungCap;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class NhaCungCapController {
	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;
	
	
	@GetMapping("/dsnhacungcap")
	public ResponseEntity<List<NhaCungCap>> layDSNhaCungCap()
	{
		List<NhaCungCap> ncc = new ArrayList<NhaCungCap>();
		
		try
		{	
			nhaCungCapRepository.findAll().forEach(ncc::add);
			
			if(ncc.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(ncc, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/nhacungcap/{mancc}")
	public ResponseEntity<Optional<NhaCungCap>> layDSNhaCungCap(@PathVariable("mancc") Integer mancc)
	{
		try
		{
			Optional<NhaCungCap> nccData = nhaCungCapRepository.findByMaNCC(mancc);
			if(nccData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(nccData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/nhacungcap_taikhoan/{taikhoan}")
	public ResponseEntity<Optional<NhaCungCap>> layDSNhaCungCapByTaiKhoan(@PathVariable("taikhoan") Integer taikhoan)
	{
		try
		{
			Optional<NhaCungCap> nccData = nhaCungCapRepository.findByTaiKhoan(taikhoan);
			if(nccData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(nccData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/nhacungcap")
	public ResponseEntity<NhaCungCap> themNhaCungCap(@RequestBody NhaCungCap ncc)
	{
		try
		{
			NhaCungCap _ncc = nhaCungCapRepository.save(new NhaCungCap(ncc.getTenNCC(), ncc.getGiayPhepKinhDoanh(),
					ncc.getSDT(), ncc.getDiaChi(), ncc.getEmail(), ncc.getSoTaiKhoanNganHang(), ncc.getTaiKhoan(), ncc.getXetDuyet()));
			return new ResponseEntity<>(_ncc, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/nhacungcap/{mancc}")
	public ResponseEntity<NhaCungCap> capNhatNhaCungCap(@PathVariable("mancc") Integer mancc, @RequestBody NhaCungCap ncc)
	{
		Optional<NhaCungCap> nccData = nhaCungCapRepository.findByMaNCC(mancc);
		
		if (nccData.isPresent())
		{
			NhaCungCap _ncc = nccData.get();
			_ncc.setTenNCC(ncc.getTenNCC());
			_ncc.setGiayPhepKinhDoanh(ncc.getGiayPhepKinhDoanh());
			_ncc.setEmail(ncc.getEmail());
			_ncc.setDiaChi(ncc.getDiaChi());
			_ncc.setSDT(ncc.getSDT());
			_ncc.setSoTaiKhoanNganHang(ncc.getSoTaiKhoanNganHang());
			_ncc.setTaiKhoan(ncc.getTaiKhoan());
			_ncc.setXetDuyet(ncc.getXetDuyet());
			return new ResponseEntity<>(nhaCungCapRepository.save(_ncc), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/nhacungcap/{mancc}")
	public ResponseEntity<HttpStatus> xoaMotNhaCungCap(@PathVariable("mancc") Integer mancc) 
	{
		try 
		{
			nhaCungCapRepository.deleteById(mancc);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/alldeletenhacungcap")
	public ResponseEntity<HttpStatus> xoaTatCaNhaCungCap() 
	{
		try 
		{
			nhaCungCapRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package com.example.Service_SanPham_NCC.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_SanPham_NCC.Repository.SanPham_NCCRepository;
import com.example.Service_SanPham_NCC.Model.SanPham_NCC;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class SanPham_NCCController {
	@Autowired
	private SanPham_NCCRepository sanPham_NCCRepository;
	
	@GetMapping("/sanpham_ncc/{mancc}")
	public ResponseEntity<List<SanPham_NCC>> layDSSanPham(@PathVariable("mancc") Integer mancc)
	{
		List<SanPham_NCC> nccData = new ArrayList<SanPham_NCC>();
		try
		{
			sanPham_NCCRepository.findByMaNCC(mancc).forEach(nccData::add);
			if(nccData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(nccData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/ncc_sanpham/{masp}")
	public ResponseEntity<List<SanPham_NCC>> layDSNCC(@PathVariable("masp") Integer masp)
	{
		List<SanPham_NCC> nccData = new ArrayList<SanPham_NCC>();
		try
		{
			sanPham_NCCRepository.findByMaSP(masp).forEach(nccData::add);
			if(nccData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(nccData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping("/sanpham_ncc")
	public ResponseEntity<List<SanPham_NCC>> layDSSPNCC()
	{
		List<SanPham_NCC> nccData = new ArrayList<SanPham_NCC>();
		try
		{
			sanPham_NCCRepository.findAll().forEach(nccData::add);
			if(nccData.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(nccData, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/spncc/{id}")
	public ResponseEntity<SanPham_NCC> laymotSP(@PathVariable("id") Integer id)
	{
		try
		{	
			Optional<SanPham_NCC> sData = sanPham_NCCRepository.findByid(id);

			if(sData.isPresent()) 
				return new ResponseEntity<>(sData.get(), HttpStatus.OK);
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

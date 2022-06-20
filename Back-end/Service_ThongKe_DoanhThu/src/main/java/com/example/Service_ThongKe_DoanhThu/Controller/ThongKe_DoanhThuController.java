package com.example.Service_ThongKe_DoanhThu.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_ThongKe_DoanhThu.Model.ThongKe_DoanhThu;
import com.example.Service_ThongKe_DoanhThu.Repository.ThongKe_DoanhThuRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class ThongKe_DoanhThuController {
	@Autowired
	private ThongKe_DoanhThuRepository nhuCauCungKyRepository;
	
	@GetMapping("/doanhthu/{mancc}")
	public ResponseEntity<List<ThongKe_DoanhThu>> laDoanhThu(@PathVariable("mancc") Integer mancc)
	{
		List<ThongKe_DoanhThu> ncck = new ArrayList<ThongKe_DoanhThu>();
		
		try
		{
			nhuCauCungKyRepository.findByMaNCC(mancc).forEach(ncck::add);
			
			if(ncck.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(ncck, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/doanhthu/{mancc}/{nam}")
	public ResponseEntity<List<ThongKe_DoanhThu>> laDoanhThuNam(@PathVariable("mancc") Integer mancc,
			@PathVariable("nam") Integer nam)
	{
		List<ThongKe_DoanhThu> ncck = new ArrayList<ThongKe_DoanhThu>();
		
		try
		{
			nhuCauCungKyRepository.findByMaNCCAndNam(mancc, nam).forEach(ncck::add);
			
			if(ncck.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(ncck, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/doanhthu/{mancc}/{nam}/{quy}")
	public ResponseEntity<List<ThongKe_DoanhThu>> laDoanhThuNam(@PathVariable("mancc") Integer mancc,
			@PathVariable("nam") Integer nam, @PathVariable("quy") Integer quy)
	{
		List<ThongKe_DoanhThu> ncck = new ArrayList<ThongKe_DoanhThu>();
		
		try
		{
			nhuCauCungKyRepository.findByMaNCCAndNamAndQuy(mancc, nam, quy).forEach(ncck::add);
			
			if(ncck.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(ncck, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

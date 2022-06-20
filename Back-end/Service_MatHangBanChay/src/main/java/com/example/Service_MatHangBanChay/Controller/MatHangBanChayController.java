package com.example.Service_MatHangBanChay.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_MatHangBanChay.Repository.MatHangBanChayRepository;
import com.example.Service_MatHangBanChay.Model.MatHangBanChay;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")

public class MatHangBanChayController {
	@Autowired
	private MatHangBanChayRepository matHangBanChayRepository;
	
	@GetMapping("/mathangbanchay")
	public ResponseEntity<List<MatHangBanChay>> layDSMatHangBanChay()
	{
		List<MatHangBanChay> mhbc = new ArrayList<MatHangBanChay>();
		
		try
		{
			matHangBanChayRepository.findAll().forEach(mhbc::add);
			
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

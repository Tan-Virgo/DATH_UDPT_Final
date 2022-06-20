package com.example.Service_NhuCauCungKyNam.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_NhuCauCungKyNam.Repository.NhuCauCungKyNamRepository;
import com.example.Service_NhuCauCungKyNam.Model.NhuCauCungKyNam;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class NhuCauCungKyNamController {
	@Autowired
	private NhuCauCungKyNamRepository nhuCauCungKyNamRepository;
	
	@GetMapping("/nhucaucungkynam")
	public ResponseEntity<List<NhuCauCungKyNam>> layDSNhuCauCungKy()
	{
		List<NhuCauCungKyNam> ncck = new ArrayList<NhuCauCungKyNam>();
		
		try
		{
			nhuCauCungKyNamRepository.findAll().forEach(ncck::add);
			
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

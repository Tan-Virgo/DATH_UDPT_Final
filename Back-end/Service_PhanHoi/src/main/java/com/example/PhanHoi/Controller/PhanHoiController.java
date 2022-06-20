package com.example.PhanHoi.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PhanHoi.Model.PhanHoi;
import com.example.PhanHoi.Repository.PhanHoiRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2082")
public class PhanHoiController {
	@Autowired
	private PhanHoiRepository phanHoiRepository;

	@GetMapping("/phanhoi")
	public ResponseEntity<List<PhanHoi>> layDSShipper()
	{
		List<PhanHoi> shipper = new ArrayList<PhanHoi>();
		
		try
		{	
			phanHoiRepository.findAll().forEach(shipper::add);

			if(shipper.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(shipper, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/phanhoi")
	public ResponseEntity<PhanHoi> themDonViVanChuyen(@RequestBody PhanHoi dvvc)
	{
		try
		{
			PhanHoi _dvvc = phanHoiRepository.save(new PhanHoi(
					dvvc.getChitiet(), dvvc.getNgaytao(), dvvc.getNguoidung(), dvvc.getSanpham(), dvvc.getNhacungcap()));
			return new ResponseEntity<>(_dvvc, HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}

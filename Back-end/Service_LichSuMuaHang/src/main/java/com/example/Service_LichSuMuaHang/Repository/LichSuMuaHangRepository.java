package com.example.Service_LichSuMuaHang.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_LichSuMuaHang.Model.LichSuMuaHang;



public interface LichSuMuaHangRepository extends JpaRepository<LichSuMuaHang, Integer>{
	@Query("SELECT * FROM V_LichSuMuaHang;")
    List<LichSuMuaHang> findByMaKH(@Param("makh") Integer makh);
	
}
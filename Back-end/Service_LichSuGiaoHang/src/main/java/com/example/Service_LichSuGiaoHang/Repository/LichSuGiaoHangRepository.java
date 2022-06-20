package com.example.Service_LichSuGiaoHang.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_LichSuGiaoHang.Model.LichSuGiaoHang;



public interface LichSuGiaoHangRepository extends JpaRepository<LichSuGiaoHang, Integer>{
	@Query("SELECT * FROM V_LichSuGiaoHang;")
	Optional<LichSuGiaoHang> findByMaDH(@Param("madh") Integer madh);
	List<LichSuGiaoHang> findByMaDVVC(@Param("madvvc") Integer madvvc);
}
package com.example.Service_MatHangBanChay.Repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import  com.example.Service_MatHangBanChay.Model.MatHangBanChay;



public interface MatHangBanChayRepository extends JpaRepository<MatHangBanChay, Integer>{
	@Query("SELECT * FROM V_ThongKe_MatHangBanChay;")
	Optional<MatHangBanChay> findByMaLoaiSP(@Param("maloaisp") Integer maloaisp);
}
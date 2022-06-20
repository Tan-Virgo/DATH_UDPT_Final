package com.example.Service_DonHang.Repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_DonHang.Model.DonHang;


public interface DonHangRepository extends JpaRepository<DonHang, Integer>{
	@Query("SELECT * FROM DonHang;")
    Optional<DonHang> findByMaDH(@Param("maDH") Integer maDH);
	Collection<? extends DonHang> findByMaKH(Integer makh);
}

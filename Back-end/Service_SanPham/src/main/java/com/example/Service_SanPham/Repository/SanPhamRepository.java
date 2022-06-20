package com.example.Service_SanPham.Repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_SanPham.Model.SanPham;


public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{
	@Query("SELECT * FROM SanPham;")
    Optional<SanPham> findByMaSP(@Param("maSP") Integer maSP);
}
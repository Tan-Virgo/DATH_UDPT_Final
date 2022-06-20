package com.example.Service_GioHang.Repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_GioHang.Model.GioHang;


public interface GioHangRepository extends JpaRepository<GioHang, Integer>{
	@Query("SELECT * FROM GioHang;")
    Optional<GioHang> findByMaGH(@Param("maGH") Integer maGH);
	Collection<? extends GioHang> findByMaKH(@Param("maKH") Integer maKH);
}

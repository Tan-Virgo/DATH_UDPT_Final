package com.example.Service_KhachHang.Repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_KhachHang.Model.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
	@Query("SELECT * FROM KhachHang;")
    Optional<KhachHang> findByMaKH(@Param("makh") Integer makh);
}

package com.example.Service_TaiKhoan.Repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import  com.example.Service_TaiKhoan.Model.TaiKhoan;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer>{
	@Query("SELECT * FROM TaiKhoan;")
	Optional<TaiKhoan> findByUserName(@Param("username") String username);
}

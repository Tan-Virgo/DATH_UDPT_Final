package com.example.Service_SanPham_NCC.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_SanPham_NCC.Model.SanPham_NCC;

public interface SanPham_NCCRepository  extends JpaRepository<SanPham_NCC, Integer>{
	@Query("SELECT * FROM V_SanPham_NCC;")
    List<SanPham_NCC> findByMaNCC(@Param("mancc") Integer mancc);
    List<SanPham_NCC> findByMaSP(@Param("masp") Integer masp);
    Optional<SanPham_NCC> findByid(@Param("id") Integer id);

}

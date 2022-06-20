package com.example.Service_NhaCungCap.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_NhaCungCap.Model.NhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {
	@Query("SELECT * FROM NhaCungCap;")
    Optional<NhaCungCap> findByMaNCC(@Param("mancc") Integer mancc);
}
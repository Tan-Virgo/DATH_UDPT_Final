package com.example.Service_DonViVanChuyen.Repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_DonViVanChuyen.Model.DonViVanChuyen;

public interface DonViVanChuyenRepository extends JpaRepository<DonViVanChuyen, Integer> {
	@Query("SELECT * FROM DonViVanChuyen;")
    Optional<DonViVanChuyen> findByMaDVVC(@Param("madvvc") Integer madvvc);
	 Optional<DonViVanChuyen> findByTaiKhoan(@Param("taikhoan") Integer taikhoan);
}

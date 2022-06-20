package com.example.Service_Shipper.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_Shipper.Model.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, Integer>{
	@Query("SELECT * FROM Shipper;")
    Optional<Shipper> findByMaShipper(@Param("mashipper") Integer mashipper);
	List<Shipper> findByMaDVVC(@Param("madvvc") Integer madvvc);
}

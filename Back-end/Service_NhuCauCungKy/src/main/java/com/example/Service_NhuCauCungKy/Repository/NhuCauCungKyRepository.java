package com.example.Service_NhuCauCungKy.Repository;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_NhuCauCungKy.Model.NhuCauCungKy;

public interface NhuCauCungKyRepository extends JpaRepository<NhuCauCungKy, Integer>{
	@Query("SELECT * FROM V_ThongKe_CungKy;")
    Optional<NhuCauCungKy> findByNam(@Param("nam") Integer nam);
	Optional<NhuCauCungKy> findByNamAndQuy(@Param("nam") Integer nam, @Param("quy") Integer quy);

}
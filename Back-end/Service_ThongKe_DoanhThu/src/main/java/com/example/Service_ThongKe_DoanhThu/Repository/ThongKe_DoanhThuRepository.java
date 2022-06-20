package com.example.Service_ThongKe_DoanhThu.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Service_ThongKe_DoanhThu.Model.ThongKe_DoanhThu;

public interface ThongKe_DoanhThuRepository extends JpaRepository<ThongKe_DoanhThu, Integer>{
	@Query("SELECT * FROM V_ThongKe_DoanhThu;")
	List<ThongKe_DoanhThu> findByMaNCC(@Param("mancc") Integer mancc);
    List<ThongKe_DoanhThu> findByMaNCCAndNam(@Param("mancc") Integer mancc, @Param("nam") Integer nam);
    List<ThongKe_DoanhThu> findByMaNCCAndNamAndQuy(@Param("mancc") Integer mancc, @Param("nam") Integer nam, @Param("quy") Integer quy);
	

}
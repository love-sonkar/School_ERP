package com.School_ERP.repository;


import com.School_ERP.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
   // List<Bus> findByEmployeeId(Long employeeId);
}


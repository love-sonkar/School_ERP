package com.School_ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.School_ERP.entity.LeaveApplication;
@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {
}

package com.School_ERP.repository;

import com.School_ERP.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceRepository extends JpaRepository<Attendence, Long> {

    Attendence findByaId(Long aId);
    Attendence findByRollNo(Long rollNo);

    int countByPresentDays(long presentDays);
    int countByAbsent(long absent);
    int countBytotalLeaves(long presentDays);
}

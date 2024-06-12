package com.School_ERP.repository;

import com.School_ERP.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AttendenceRepository extends JpaRepository<Attendence, Long> {

    Attendence findByaId(Long aId);
    List<Attendence> findByRollNo(Long rollNo);

    Attendence findByRollNoAndDate(long rollNo, LocalDate date);

    int countByPresentDays(long presentDays);
    int countByAbsent(long absent);
    int countBytotalLeaves(long presentDays);
}

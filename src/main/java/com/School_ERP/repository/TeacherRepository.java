package com.School_ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.School_ERP.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

package com.School_ERP.repository;

import com.School_ERP.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<Parent, Long> {
    Parent findByParentId(long parentId);

    Parent findByStudentId(long studentId);
}

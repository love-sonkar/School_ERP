package com.School_ERP.repository;

import com.School_ERP.entity.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionBankRepository extends JpaRepository<QuestionBank,Long> {

    QuestionBank findBySubjectAndYear(String subject, int year);

    List<QuestionBank> findByYear(int year);

    List<QuestionBank> findBySubject(String subject);
}

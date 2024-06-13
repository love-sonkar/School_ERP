package com.School_ERP.service;

import com.School_ERP.entity.QuestionBank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QuestionBankService {

    List<QuestionBank> getAllQuestionBanks();
    List<QuestionBank> getQuestionBanksBySubject( String subject);
    ResponseEntity<?> addQuestionBank( QuestionBank questionBank);
    ResponseEntity<QuestionBank> getQuestionBankBySubjectAndYear( String subject, int year);
    List<QuestionBank> getQuestionBanksByYear(int year);
    ResponseEntity<?> updateQuestionBankBySubjectAndYear( String subject,  int year, QuestionBank questionBank);

}

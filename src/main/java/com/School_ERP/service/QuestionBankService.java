package com.School_ERP.service;

import com.School_ERP.dto.QuestionBankDto;
import com.School_ERP.entity.QuestionBank;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionBankService {

    List<QuestionBankDto> getAllQuestionBanks();
    List<QuestionBankDto> getQuestionBanksBySubject( String subject);
    ResponseEntity<?> addQuestionBank( QuestionBank questionBank);
    ResponseEntity<QuestionBankDto> getQuestionBankBySubjectAndYear( String subject, int year);
    List<QuestionBankDto> getQuestionBanksByYear(int year);
    ResponseEntity<?> updateQuestionBankBySubjectAndYear( String subject,  int year, QuestionBankDto questionBankDto);

}

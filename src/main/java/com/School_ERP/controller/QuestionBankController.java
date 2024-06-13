package com.School_ERP.controller;


import com.School_ERP.dto.QuestionBankDto;
import com.School_ERP.entity.QuestionBank;
import com.School_ERP.links.QuestionBankLinks;
import com.School_ERP.service.QuestionBankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(QuestionBankLinks.QUESTIONBANK)
@Tag(name = "QuestionBank", description = "API for QuestionBank")
public class QuestionBankController {


    @Autowired
    QuestionBankService questionBankService;

    @GetMapping(path = QuestionBankLinks.GET_ALL_QUESTIONPAPER)
    public List<QuestionBankDto> getAllQuestionBanks() {
        return questionBankService.getAllQuestionBanks();
    }

    @GetMapping(path = QuestionBankLinks.GET_QUESTIONBANKS_BY_YEAR)
    public List<QuestionBankDto> getQuestionBanksByYear(@PathVariable String year) {
        return questionBankService.getQuestionBanksByYear(Integer.parseInt(year));
    }

    @GetMapping(path = QuestionBankLinks.GET_QUESTIONBANKS_BY_SUBJECT)
    public List<QuestionBankDto> getQuestionBanksBySubject(@PathVariable String subject) {
        return questionBankService.getQuestionBanksBySubject(subject);
    }


    @PostMapping(path = QuestionBankLinks.ADD_QUESTIONBANK)
    public ResponseEntity<?> addQuestionBank(@RequestBody QuestionBank questionBank) {

        return questionBankService.addQuestionBank(questionBank);
    }

    @GetMapping(path = QuestionBankLinks.GET_QUESTIONBANK_BY_SUBJECT_AND_YEAR)
    public ResponseEntity<QuestionBankDto> getQuestionBankBySubjectAndYear(@PathVariable String subject, @PathVariable String year) {
        return questionBankService.getQuestionBankBySubjectAndYear(subject, Integer.parseInt(year));
    }

    @PutMapping(path = QuestionBankLinks.UPDATE_QUESTIONBANK_BY_SUBJECT_AND_YEAR)
    public ResponseEntity<?> updateQuestionBankBySubjectAndYear(@PathVariable String subject, @PathVariable String year, @RequestBody QuestionBankDto questionBankDto) {
        return questionBankService.updateQuestionBankBySubjectAndYear(subject, Integer.parseInt(year), questionBankDto);
    }
}
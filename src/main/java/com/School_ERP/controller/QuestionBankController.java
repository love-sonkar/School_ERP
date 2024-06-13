package com.School_ERP.controller;


import com.School_ERP.entity.QuestionBank;
import com.School_ERP.links.QuestionBankLinks;
import com.School_ERP.repository.QuestionBankRepository;
import com.School_ERP.service.QuestionBankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(QuestionBankLinks.QUESTIONBANK)
@RestController
@Tag(name = "QuestionBank", description = "API for QuestionBank")
public class QuestionBankController {


    @Autowired
    QuestionBankService questionBankService;

    @GetMapping(path = QuestionBankLinks.GET_ALL_QUESTIONPAPER)
    public List<QuestionBank> getAllQuestionBanks() {
        return questionBankService.getAllQuestionBanks();
    }

    @GetMapping(path = QuestionBankLinks.GET_QUESTIONBANKS_BY_YEAR)
    public List<QuestionBank> getQuestionBanksByYear(@PathVariable String year) {
        return questionBankService.getQuestionBanksByYear(Integer.parseInt(year));
    }

    @GetMapping(path = QuestionBankLinks.GET_QUESTIONBANKS_BY_SUBJECT)
    public List<QuestionBank> getQuestionBanksBySubject(@PathVariable String subject) {
        return questionBankService.getQuestionBanksBySubject(subject);
    }


    @PostMapping(path = QuestionBankLinks.ADD_QUESTIONBANK)
    public ResponseEntity<?> addQuestionBank(@RequestBody QuestionBank questionBank) {

        return questionBankService.addQuestionBank(questionBank);
    }

    @GetMapping(path = QuestionBankLinks.GET_QUESTIONBANK_BY_SUBJECT_AND_YEAR)
    public ResponseEntity<QuestionBank> getQuestionBankBySubjectAndYear(@PathVariable String subject, @PathVariable String year) {
        return questionBankService.getQuestionBankBySubjectAndYear(subject, Integer.parseInt(year));
    }

    @PutMapping(path = QuestionBankLinks.UPDATE_QUESTIONBANK_BY_SUBJECT_AND_YEAR)
    public ResponseEntity<?> updateQuestionBankBySubjectAndYear(@PathVariable String subject, @PathVariable String year, @RequestBody QuestionBank questionBank) {
        return questionBankService.updateQuestionBankBySubjectAndYear(subject, Integer.parseInt(year), questionBank);
    }
}
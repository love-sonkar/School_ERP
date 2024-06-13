package com.School_ERP.service.serviceImp;

import com.School_ERP.entity.QuestionBank;
import com.School_ERP.repository.QuestionBankRepository;
import com.School_ERP.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionBankImp  implements QuestionBankService {

    @Autowired
    QuestionBankRepository questionBankRepository;


    @Override
    public List<QuestionBank> getAllQuestionBanks() {
        return questionBankRepository.findAll();
    }

    @Override
    public List<QuestionBank> getQuestionBanksBySubject(String subject) {
        return questionBankRepository.findBySubject(subject);
    }

    @Override
    public ResponseEntity<?> addQuestionBank(QuestionBank questionBank) {
        QuestionBank questionbank = questionBankRepository.save(questionBank);
        return new ResponseEntity<>(questionBank, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<QuestionBank> getQuestionBankBySubjectAndYear(String subject, int year) {
        QuestionBank questionBank = questionBankRepository.findBySubjectAndYear(subject, year);
        if (questionBank != null) {
            return new ResponseEntity<>(questionBank, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<QuestionBank> getQuestionBanksByYear(int year) {
        return questionBankRepository.findByYear(year);
    }

    @Override
    public ResponseEntity<?> updateQuestionBankBySubjectAndYear(String subject, int year, QuestionBank questionBank) {
        QuestionBank questionbank = questionBankRepository.findBySubjectAndYear(subject, year);
        if (questionbank != null) {
            if(questionBank.getSubject().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("subject is empty");
            }
            if(questionBank.getYear()==0){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("year is empty");
            }
            questionbank.setSubject(questionBank.getSubject());
            questionbank.setYear(questionBank.getYear());
            questionBankRepository.save(questionbank);
            return new ResponseEntity<>(questionbank, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong");
    }

}

package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.dto.QuestionBankDto;
import com.School_ERP.entity.QuestionBank;
import com.School_ERP.repository.QuestionBankRepository;
import com.School_ERP.service.QuestionBankService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionBankImp  implements QuestionBankService {

    @Autowired
    QuestionBankRepository questionBankRepository;

    @Autowired
    ModelMapper mapper;


    @Override
    public List<QuestionBankDto> getAllQuestionBanks() {
        List<QuestionBank> questionBank = questionBankRepository.findAll();
        List<QuestionBankDto> list = questionBank.stream().map(question -> {
            QuestionBankDto dto = null;
            dto = mapper.map(question, QuestionBankDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<QuestionBankDto> getQuestionBanksBySubject(String subject) {
        List<QuestionBank> questionBank = questionBankRepository.findBySubject(subject);
        List<QuestionBankDto> list = questionBank.stream().map(question -> {
            QuestionBankDto dto = null;
            dto = mapper.map(question, QuestionBankDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public ResponseEntity<?> addQuestionBank(QuestionBank questionBank) {
        QuestionBank questionbank = questionBankRepository.save(questionBank);
        return new ResponseEntity<>(questionBank, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<QuestionBankDto> getQuestionBankBySubjectAndYear(String subject, int year) {
        QuestionBank questionBank = questionBankRepository.findBySubjectAndYear(subject, year);
        if (questionBank != null) {
            QuestionBankDto convertToDto = mapper.map(questionBank, QuestionBankDto.class);
            return new ResponseEntity<>(convertToDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<QuestionBankDto> getQuestionBanksByYear(int year) {
        List<QuestionBank> questionBank = questionBankRepository.findByYear(year);
        List<QuestionBankDto> list = questionBank.stream().map(question -> {
            QuestionBankDto dto = null;
            dto = mapper.map(question, QuestionBankDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public ResponseEntity<?> updateQuestionBankBySubjectAndYear(String subject, int year, QuestionBankDto questionBankDto) {
        QuestionBank questionbank = questionBankRepository.findBySubjectAndYear(subject, year);
        if (questionbank != null) {
            if(questionBankDto.getSubject().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("subject is empty");
            }
            if(questionBankDto.getYear()==0){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("year is empty");
            }
            questionbank.setSubject(questionBankDto.getSubject());
            questionbank.setYear(questionBankDto.getYear());
            QuestionBank savedQuestionBank = questionBankRepository.save(questionbank);
            QuestionBankDto convertToDto = mapper.map(savedQuestionBank, QuestionBankDto.class);
            return new ResponseEntity<>(convertToDto, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong");
    }

}

package com.School_ERP.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionBankDto {

    private Long qbId;
    private String subject;
    private int year;
    private String document;
}

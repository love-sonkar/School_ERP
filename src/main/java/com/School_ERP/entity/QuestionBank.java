package com.School_ERP.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Schema(description = "Entity representing for all previous year of Question Paper")
public class QuestionBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qbId;

    @Schema(description = "Choose subject", example = "Mathematics")
    private String subject;

    @Schema(description = "Choose year", example = "2023")
    private int year;

    @Schema(description = "Choose any Documents", example = "maths_questionPaper.pdf")
    private String document;

}

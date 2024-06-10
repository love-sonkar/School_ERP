package com.School_ERP.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Entity representing for library management system")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the Library", example = "1")
    private long bookId;

    @Schema(description = "Unique identifier for student", example = "2")
    private long studentId;

    @Schema(description = "request to take book", example = "access granted")
    private String request;

    @Schema(description = "Book is available or not", example = "yes or no")
    private String status;

    @Schema(description = "All subject of books", example = "math,english,hindi,social science,science,computer science")
    private String books;

}

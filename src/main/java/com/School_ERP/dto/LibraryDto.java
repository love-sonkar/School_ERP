package com.School_ERP.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibraryDto {
    private long lid;
    private String request;
    private String status;
    private String books;
}

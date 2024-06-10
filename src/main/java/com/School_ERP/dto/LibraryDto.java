package com.School_ERP.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

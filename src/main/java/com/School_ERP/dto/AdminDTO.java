package com.School_ERP.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for Admin")
public class AdminDTO {

    @Schema(description = "Username of the admin", example = "admin123")
    private String userName;

    @Schema(description = "Password of the admin", example = "password")
    private String password;
}

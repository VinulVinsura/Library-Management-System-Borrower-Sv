package com.example.librarymanagesystemborrowerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDataDto {
    private String email;
    private String password;
}

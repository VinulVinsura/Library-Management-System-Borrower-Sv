package com.example.librarymanagesystemborrowerservice.service;

import com.example.librarymanagesystemborrowerservice.dto.LoginDataDto;

public interface LoginService {
    void insertLoginData(LoginDataDto loginDataDto);
    boolean loginValidation(LoginDataDto loginDataDto);

    boolean deleteLoginData(String userName);
}


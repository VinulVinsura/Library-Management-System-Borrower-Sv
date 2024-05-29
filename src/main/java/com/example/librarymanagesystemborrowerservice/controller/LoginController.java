package com.example.librarymanagesystemborrowerservice.controller;

import com.example.librarymanagesystemborrowerservice.dto.LoginDataDto;
import com.example.librarymanagesystemborrowerservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/isValidUser")
     public boolean loginValidation(@RequestBody LoginDataDto loginDataDto){
        return loginService.loginValidation(loginDataDto);
    }

}

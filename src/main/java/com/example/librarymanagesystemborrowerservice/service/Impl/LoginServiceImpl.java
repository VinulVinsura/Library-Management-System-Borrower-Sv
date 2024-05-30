package com.example.librarymanagesystemborrowerservice.service.Impl;

import com.example.librarymanagesystemborrowerservice.dto.LoginDataDto;
import com.example.librarymanagesystemborrowerservice.entity.LoginData;
import com.example.librarymanagesystemborrowerservice.repository.LoginRepo;
import com.example.librarymanagesystemborrowerservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void insertLoginData(LoginDataDto loginDataDto) {
        LoginData loginData = loginRepo.save(modelMapper.map(loginDataDto, LoginData.class));
        log.info(loginData.toString());
    }

    @Override
    public boolean loginValidation(LoginDataDto loginDataDto) {
        return loginRepo.existsByEmailAndPassword(loginDataDto.getEmail(),loginDataDto.getPassword());

    }




    @Override
    public boolean deleteLoginData(String userName) {
        Integer i = loginRepo.deleteByUserName(userName);
        log.info(i.toString());
        return true;
    }
}

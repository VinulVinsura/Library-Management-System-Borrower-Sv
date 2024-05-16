package com.example.librarymanagesystemborrowerservice.service.Impl;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;
import com.example.librarymanagesystemborrowerservice.entity.Borrower;
import com.example.librarymanagesystemborrowerservice.repository.BorrowerRepo;
import com.example.librarymanagesystemborrowerservice.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    BorrowerRepo borrowerRepo;

    ModelMapper modelMapper;

    @Bean
    public void setModelMapper(){
        this.modelMapper=new ModelMapper();
    }

    @Override
    public boolean addBorrower(BorrowerDto borrowerDto) {
       if (borrowerDto.getBorrower_Id()!=null &&
               borrowerDto.getFirstName()!=null &&
               borrowerDto.getLastName()!=null &&
               borrowerDto.getEmail() !=null &&
               borrowerDto.getAddress()!=null &&
               borrowerDto.getPassword()!=null &&
               borrowerDto.getUsername()!=null &&
               borrowerDto.getPhoneNum()!=null){
           borrowerRepo.save(modelMapper.map(borrowerDto, Borrower.class));
           return true;
       }
       return false;

    }
}
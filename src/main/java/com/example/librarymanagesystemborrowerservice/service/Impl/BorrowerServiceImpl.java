package com.example.librarymanagesystemborrowerservice.service.Impl;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;
import com.example.librarymanagesystemborrowerservice.entity.Borrower;
import com.example.librarymanagesystemborrowerservice.repository.BorrowerRepo;
import com.example.librarymanagesystemborrowerservice.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    BorrowerRepo borrowerRepo;

    @Autowired
    ModelMapper modelMapper;



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

    @Override
    public List<BorrowerDto> getBorrowers() {
        List<Borrower> borrowerList = borrowerRepo.findAll();
        return modelMapper.map(borrowerList, new TypeToken<List<BorrowerDto>>(){}.getType());
    }

    @Override
    public boolean deleteBorrower(Integer id) {
        if (borrowerRepo.existsById(id)){
            System.out.println("1");
            borrowerRepo.deleteById(id);
            System.out.println("2");
            return true;
        }
        return false;
    }

    @Override
    public BorrowerDto serachByUserName(String userName) {
        return modelMapper.map(borrowerRepo.findByUsername(userName), BorrowerDto.class);

    }

}

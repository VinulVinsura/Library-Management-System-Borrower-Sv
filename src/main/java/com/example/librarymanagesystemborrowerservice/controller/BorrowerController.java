package com.example.librarymanagesystemborrowerservice.controller;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;
import com.example.librarymanagesystemborrowerservice.dto.LoginDataDto;
import com.example.librarymanagesystemborrowerservice.dto.Response;
import com.example.librarymanagesystemborrowerservice.entity.Borrower;
import com.example.librarymanagesystemborrowerservice.service.BorrowerService;
import com.example.librarymanagesystemborrowerservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/api/borrower")
@CrossOrigin
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    LoginService loginService;


    @PostMapping("/addBorrower")
    public Response addBorrower(@RequestBody BorrowerDto borrowerDto){
        //set to values LoginData Table
        loginService.insertLoginData(new LoginDataDto(borrowerDto.getEmail(),borrowerDto.getPassword()));

        return  (borrowerService.addBorrower(borrowerDto)) ? new Response("Save successfully"):
                                                            new Response("Can't save borrower..");


    }

    @GetMapping("/getAllBorrowers")
    public List<BorrowerDto> getAllBorrowers(){
         return borrowerService.getBorrowers();
    }

    @DeleteMapping("/deleteBorrower/{id}")
     public Response deleteBorrower(@PathVariable Integer id){
          if (borrowerService.deleteBorrower(id)){
             return new Response("Delete Successfully..");
          }
          return new Response("Delete Fail...");
     }
     @GetMapping("/searchByUserName/{userName}")
    public BorrowerDto searchByUserName (@PathVariable String userName){
         return borrowerService.serachByUserName(userName);
     }

     @GetMapping("/isExistsByUserName/{userName}")
    public boolean isExistsByUserName(@PathVariable String userName){
        return borrowerService.isExistsByUserName(userName);
     }
}

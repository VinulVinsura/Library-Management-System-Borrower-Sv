package com.example.librarymanagesystemborrowerservice.controller;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;
import com.example.librarymanagesystemborrowerservice.dto.Response;
import com.example.librarymanagesystemborrowerservice.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrower")
@CrossOrigin
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/addBorrower")
    public Response addBorrower(@RequestBody BorrowerDto borrowerDto){
       return  (borrowerService.addBorrower(borrowerDto)) ? new Response(borrowerDto.getBorrower_Id(),"save successfully"):
                                                            new Response(borrowerDto.getBorrower_Id(),"Can't save borrower..");
    }

    @GetMapping("/getAllBorrowers")
    public List<BorrowerDto> getAllBorrowers(){
         return borrowerService.getBorrowers();
    }

    @DeleteMapping("/deleteBorrower/{id}")
     public Response deleteBorrower(@PathVariable Integer id){
          if (borrowerService.deleteBorrower(id)){
             return new Response("","Delete Successfully..");
          }
          return new Response("","Delete Fail...");
     }
}

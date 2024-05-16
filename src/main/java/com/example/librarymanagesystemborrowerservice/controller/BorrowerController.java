package com.example.librarymanagesystemborrowerservice.controller;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;
import com.example.librarymanagesystemborrowerservice.dto.Response;
import com.example.librarymanagesystemborrowerservice.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrower")
@CrossOrigin
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/addBorrower")
    public Response addBorrower(@RequestBody BorrowerDto borrowerDto){
       return  (borrowerService.addBorrower(borrowerDto)) ? new Response(borrowerDto.getBorrower_Id(),"save successfully"):
                                                            new Response(borrowerDto.getBorrower_Id(),"Borrower is already saved");


    }
}
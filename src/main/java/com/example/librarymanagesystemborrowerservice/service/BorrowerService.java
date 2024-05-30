package com.example.librarymanagesystemborrowerservice.service;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;
import com.example.librarymanagesystemborrowerservice.entity.Borrower;

import java.util.List;

public interface BorrowerService {
     boolean addBorrower(BorrowerDto borrowerDto);
     List<BorrowerDto> getBorrowers();
     boolean deleteBorrower(String username);
     BorrowerDto serachByUserName(String userName);
     boolean isExistsByUserName(String userName);
}

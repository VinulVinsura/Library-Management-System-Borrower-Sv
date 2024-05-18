package com.example.librarymanagesystemborrowerservice.service;

import com.example.librarymanagesystemborrowerservice.dto.BorrowerDto;

import java.util.List;

public interface BorrowerService {
     boolean addBorrower(BorrowerDto borrowerDto);
     List<BorrowerDto> getBorrowers();
}

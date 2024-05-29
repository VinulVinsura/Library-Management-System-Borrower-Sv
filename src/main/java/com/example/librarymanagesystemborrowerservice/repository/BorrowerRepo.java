package com.example.librarymanagesystemborrowerservice.repository;

import com.example.librarymanagesystemborrowerservice.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepo extends JpaRepository<Borrower,Integer> {

    Borrower findByUsername(String userName);
    boolean existsByUsername(String userName);


}

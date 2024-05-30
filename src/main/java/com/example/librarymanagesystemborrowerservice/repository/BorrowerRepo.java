package com.example.librarymanagesystemborrowerservice.repository;

import com.example.librarymanagesystemborrowerservice.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BorrowerRepo extends JpaRepository<Borrower,Integer> {

    Borrower findByUsername(String userName);
    boolean existsByUsername(String userName);

    @Modifying
    @Transactional
    @Query("DELETE from Borrower where username=:userName") // Custom delete query Using UserName
    Integer deleteByUsername(String userName);

}

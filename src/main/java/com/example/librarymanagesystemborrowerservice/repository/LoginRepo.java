package com.example.librarymanagesystemborrowerservice.repository;

import com.example.librarymanagesystemborrowerservice.entity.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LoginRepo extends JpaRepository<LoginData,Integer> {
    boolean existsByEmailAndPassword(String email,String password);

    @Transactional
    @Modifying
    @Query("DELETE from LoginData where userName=:userName")
    Integer deleteByUserName(String userName);

}

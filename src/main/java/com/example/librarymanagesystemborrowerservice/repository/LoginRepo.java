package com.example.librarymanagesystemborrowerservice.repository;

import com.example.librarymanagesystemborrowerservice.entity.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<LoginData,Integer> {
    boolean existsByEmailAndPassword(String email,String password);
}

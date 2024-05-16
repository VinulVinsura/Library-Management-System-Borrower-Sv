package com.example.librarymanagesystemborrowerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String borrower_Id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNum;
}

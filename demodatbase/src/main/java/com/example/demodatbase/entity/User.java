package com.example.demodatbase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Locale;

@Entity
public class User {
    @Id
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastName;
    private LocalDate dob;


}

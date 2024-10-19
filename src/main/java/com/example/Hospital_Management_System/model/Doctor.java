package com.example.Hospital_Management_System.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Doctor {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String experience;
    private Timestamp createdAt;
    private Timestamp updateAt;

}

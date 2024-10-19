package com.example.Hospital_Management_System.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {


    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String gender;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Patient(String name,String address,String phoneNumber,String gender,String email){
        this.name =name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.gender=gender;
        this.email=email;
    }


}

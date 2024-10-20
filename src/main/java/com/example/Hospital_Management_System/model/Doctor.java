package com.example.Hospital_Management_System.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String experience;

    @Column(nullable = false)
    @CreatedDate
    private Timestamp createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Timestamp updateAt;

}

package com.example.Hospital_Management_System.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    private int id;
    private int patientId;
    private String patientName;
    private int doctorId;
    private String doctorName;
    private double amount;
    private Status status;
    private PaymentMethod paymentMethod;
    private LocalDateTime billingDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

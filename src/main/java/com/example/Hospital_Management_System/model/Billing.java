package com.example.Hospital_Management_System.model;
import com.example.Hospital_Management_System.utils.BillingStatus;
import com.example.Hospital_Management_System.utils.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int patientId;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private int doctorId;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private BillingStatus status;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private LocalDateTime billingDate;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime updatedAt;
}

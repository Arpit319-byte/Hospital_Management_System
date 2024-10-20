package com.example.Hospital_Management_System.model;

import com.example.Hospital_Management_System.utils.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    private int id;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private AppointmentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

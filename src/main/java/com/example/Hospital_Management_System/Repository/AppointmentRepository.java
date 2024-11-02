package com.example.Hospital_Management_System.Repository;

import com.example.Hospital_Management_System.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.InterfaceAddress;

@Repository
 public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}

package com.example.Hospital_Management_System.Repository;
import com.example.Hospital_Management_System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}

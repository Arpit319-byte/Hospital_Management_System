package com.example.Hospital_Management_System.Service;
import com.example.Hospital_Management_System.Repository.PatientRepository;
import com.example.Hospital_Management_System.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public Patient getPatientById(int patientId) {
        return  patientRepository.findById(patientId).orElse(null);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(int patientId, Patient patient) {
            Optional<Patient> patientOptional = patientRepository.findById(patientId);
            if (patientOptional.isPresent()) {
                Patient p = patientOptional.get();
                p.setName(patient.getName());
                p.setAddress(patient.getAddress());
                p.setGender(patient.getGender());
                p.setEmail(patient.getEmail());
                p.setPhoneNumber(patient.getPhoneNumber());
                return patientRepository.save(p);
            }
            return null;
    }


    public boolean deletePatientById(int patientId) {
        if(patientRepository.existsById(patientId)){
            patientRepository.deleteById(patientId);
            return true;
        }
        return false;
    }
}

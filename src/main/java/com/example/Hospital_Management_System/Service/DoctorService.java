package com.example.Hospital_Management_System.Service;

import com.example.Hospital_Management_System.Repository.DoctorRepository;
import com.example.Hospital_Management_System.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }


    public boolean deleteDoctorById(int doctorId) {

        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
            return true;
        }
        return false;
    }


    public Doctor updateDoctorId(int doctorId,Doctor updateDoctor) {

        Optional<Doctor> optionalDoctor=doctorRepository.findById(doctorId);

        if(optionalDoctor.isPresent()){
            Doctor d=optionalDoctor.get();
            d.setName(updateDoctor.getName());
            d.setEmail(updateDoctor.getEmail());
            d.setPhoneNumber(updateDoctor.getPhoneNumber());
            d.setExperience(updateDoctor.getExperience());
            doctorRepository.save(d);
            return d;
        }
        return null;
    }


    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

}

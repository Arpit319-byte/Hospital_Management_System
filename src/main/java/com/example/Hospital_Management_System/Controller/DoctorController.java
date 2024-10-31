package com.example.Hospital_Management_System.Controller;

import com.example.Hospital_Management_System.Service.DoctorService;
import com.example.Hospital_Management_System.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctor(){
        return new ResponseEntity<List<Doctor>>(doctorService.getAllDoctor(), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId){
        Doctor d=doctorService.getDoctorById(doctorId);

        if(d != null)
            return new ResponseEntity<>(d,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        return new ResponseEntity<Doctor>(doctorService.addDoctor(doctor),HttpStatus.OK);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable int doctorId){

        boolean isRemoved=doctorService.deleteDoctorById(doctorId);

        if(!isRemoved)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{/{doctorId}")
    public ResponseEntity<Doctor> updateDoctorById(@PathVariable int doctorId,@RequestBody Doctor doctor){
           Doctor d=doctorService.updateDoctorId(doctorId,doctor);

           if(d == null)
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(d,HttpStatus.OK);

    }

}

package com.example.Hospital_Management_System.Controller;
import com.example.Hospital_Management_System.Service.PatientService;
import com.example.Hospital_Management_System.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId){
       Patient p=patientService.getPatientById(patientId);

        if(p==null)
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       return new ResponseEntity<>(p,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient(){
        return new ResponseEntity<List<Patient>>(patientService.getAllPatient(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
       Patient p = patientService.addPatient(patient);
       return new ResponseEntity<>(p,HttpStatus.CREATED);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int patientId,@RequestBody Patient patient){
          Patient p =patientService.updatePatient(patientId,patient);

          if(p == null)
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          return new ResponseEntity<>(p,HttpStatus.OK);

    }


    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatientById(@PathVariable int patientId){
        boolean isRemoved=patientService.deletePatientById(patientId);

        if(!isRemoved)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

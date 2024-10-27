package com.example.Hospital_Management_System.Controller;
import com.example.Hospital_Management_System.Service.AppointmentService;
import com.example.Hospital_Management_System.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

   private final  AppointmentService appointmentService;

    @Autowired
    void appointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> allAppointment(){
        List<Appointment> appointmentList=appointmentService.getAllAppointment();

        if (appointmentList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return  new ResponseEntity<List<Appointment>>(appointmentList, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable int patientId){
        Appointment appointment=appointmentService.getAppointmentById(patientId);

        if(appointment == null)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable int patientId ,@RequestBody Appointment newAppointment){
        Appointment updateAppointment=appointmentService.updateAppointment(patientId,newAppointment);

                if(updateAppointment == null)
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(updateAppointment,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment>  createAppointment(@RequestBody Appointment appointment){
        Appointment a=appointmentService.createNewAppointment(appointment);
        return new ResponseEntity<>(a,HttpStatus.CREATED);

    }


    @DeleteMapping("/{patientId}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable int patientId){
        boolean isRemoved=appointmentService.deleteAppointmentById(patientId);

                if(!isRemoved)
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

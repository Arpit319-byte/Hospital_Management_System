package com.example.Hospital_Management_System.Controller;
import com.example.Hospital_Management_System.model.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    AppointmentService appointmentService;

    void appointmentController(AppointmentService appointmentService){
        this.appointmentService=appintmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> allAppointment(){
        return  new ResponseEntity<List<Appointment>>(appointmentService.getAllAppointment(), HttpStatus.OK);
    }


}

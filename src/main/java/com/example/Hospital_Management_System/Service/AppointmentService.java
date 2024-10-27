package com.example.Hospital_Management_System.Service;
import com.example.Hospital_Management_System.Repository.AppointmentRepository;
import com.example.Hospital_Management_System.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {

    AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }


    public Appointment getAppointmentById(int patientId) {
        return appointmentRepository.findById(patientId).orElse(null);
    }

    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }


    public Appointment createNewAppointment(Appointment appointment) {
       return appointmentRepository.save(appointment);
    }



    public Appointment updateAppointment(int patientId, Appointment newAppointment) {
        Appointment appointment=appointmentRepository.findById(patientId).orElse(null);

        if(appointment == null)
            return null;
        else{

            appointment.setPatientId(newAppointment.getPatientID());
            appointment.setDocotorId(newAppointment.getDoctorID());
            appointment.setAppointmentDate(newAppointment.getAppointmentDate());
            appointment.setStatus(newAppointment.getStatus());
        }

        return appointment;
    }



    public boolean deleteAppointmentById(int patientId) {
        Appointment appointment=appointmentRepository.findById(patientId).orElse(null);

        return appointment != null;

    }
}

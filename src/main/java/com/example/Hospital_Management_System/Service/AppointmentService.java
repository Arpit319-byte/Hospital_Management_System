package com.example.Hospital_Management_System.Service;
import com.example.Hospital_Management_System.Repository.AppointmentRepository;
import com.example.Hospital_Management_System.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        Optional<Appointment > appointmentOptional =appointmentRepository.findById(patientId);

            if (appointmentOptional.isPresent()) {
                Appointment appointment= appointmentOptional.get();
                appointment.setPatientId(newAppointment.getPatientId());
                appointment.setDoctorId(newAppointment.getDoctorId());
                appointment.setAppointmentDate(newAppointment.getAppointmentDate());
                appointment.setStatus(newAppointment.getStatus());
                return  appointmentRepository.save(appointment);
            }
            return null;
    }


    public boolean deleteAppointmentById(int patientId) {
        if(appointmentRepository.existsById(patientId)) {
            appointmentRepository.deleteById(patientId);
            return true;
        }
        return false;
    }
}

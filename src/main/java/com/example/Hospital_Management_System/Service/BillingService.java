package com.example.Hospital_Management_System.Service;
import com.example.Hospital_Management_System.Repository.BillingRepository;
import com.example.Hospital_Management_System.model.Billing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository){
        this.billingRepository=billingRepository;
    }


    public Billing getBillById(int billId) {
        return billingRepository.findById(billId).orElse(null);
    }

    public List<Billing> getAllBill() {
        return billingRepository.findAll();
    }

    public Billing addBill(Billing bill) {
        return billingRepository.save(bill);
    }

    public Billing updateBill(int billId, Billing bill) {

        Billing b=billingRepository.findById(billId).orElse(null);
        if(b != null){

            b.setAmount(bill.getAmount());
            b.setStatus(bill.getStatus());
            b.setDoctorName(bill.getDoctorName());
            b.setPatientName(bill.getPatientName());
            b.setDoctorId(bill.getDoctorId());
            b.setPatientId(bill.getPatientId());
            billingRepository.save(b);
            return b;
        }
        return null;
    }

    public boolean deleteBillById(int billId) {

        if(billingRepository.existsById(billId)){
            billingRepository.deleteById(billId);
            return true;
        }
        return false;
    }
}

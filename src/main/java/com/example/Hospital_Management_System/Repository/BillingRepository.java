package com.example.Hospital_Management_System.Repository;
import com.example.Hospital_Management_System.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer> {

}

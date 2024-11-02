package com.example.Hospital_Management_System.Controller;

import com.example.Hospital_Management_System.Service.BillingService;
import com.example.Hospital_Management_System.model.Billing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    private final BillingService billService;

    public BillController(BillingService billService){
        this.billService=billService;
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Billing> getBillById(@PathVariable int billId){
        Billing b=billService.getBillById(billId);

        if(b == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Billing>(b,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Billing>> getAllBills(){
        return new ResponseEntity<List<Billing>>(billService.getAllBill(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Billing> addBill(@RequestBody Billing bill){
        return new ResponseEntity<Billing>(billService.addBill(bill),HttpStatus.CREATED);
    }

    @PutMapping("/{billId}")
    public ResponseEntity<Billing> updateBill(@PathVariable int billId,@RequestBody Billing bill){
        Billing b=billService.updateBill(billId,bill);

        if(b == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Billing>(b,HttpStatus.OK);

    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<Billing> deleteBillById(@PathVariable int billId){
        boolean isRemoved = billService.deleteBillById(billId);

        if(!isRemoved)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

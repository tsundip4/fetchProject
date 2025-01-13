package com.fetchProject.demo.controller;

import com.fetchProject.demo.model.Receipt;
import com.fetchProject.demo.service.ServiceForReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ControllerForReceipt {
    @Autowired
    private ServiceForReceipt receiptService;

    // Endpoint to process receipts
    @PostMapping("/process")
    public ResponseEntity<?> processReceipt(@RequestBody Receipt receipt) {
        String id = receiptService.processReceipt(receipt);
        return ResponseEntity.ok(Map.of("id", id)); // Return receipt ID
    }

    // Endpoint to retrieve points
    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoints(@PathVariable String id) {
        Integer points = receiptService.getPoints(id);
        if (points == null) {
        return ResponseEntity.notFound().build(); // Return 404 if ID not found
        }
        return ResponseEntity.ok(Map.of("points", points)); // Return points
    }
}

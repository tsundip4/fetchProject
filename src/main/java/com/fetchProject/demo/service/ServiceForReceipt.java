package com.fetchProject.demo.service;

import com.fetchProject.demo.model.Receipt;
import com.fetchProject.demo.storage.ReceiptRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceForReceipt {
    //to process the receipt
    public String processReceipt(Receipt receipt) {
        UUID uuid = UUID.randomUUID();// Generate unique// ID
        String id = uuid.toString();
        int points = PointCalculator.pointsCalculate(receipt); // Calculate points
        ReceiptRepo.saveReceipt(id, points); // Save receipt ID and points
        return id;
    }

    // points for a given ID
    public Integer getPoints(String id) {
        return ReceiptRepo.getPoints(id);
    }
}

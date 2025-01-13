package com.fetchProject.demo.storage;

import java.util.HashMap;
import java.util.Map;

// This class will provide repo to put and retrieve the data
public class ReceiptRepo {
    //Use hashmap for in memory storage
    private static final Map<String, Integer> receiptStore = new HashMap<>();

    // Saves a receipt with its points
    public static void saveReceipt(String id, int points) {
        receiptStore.put(id, points);
    }

    // Retrieves points for a given receipt ID
    public static Integer getPoints(String id) {
        return receiptStore.get(id);
    }
}

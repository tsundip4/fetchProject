package com.fetchProject.demo.service;

import com.fetchProject.demo.model.Item;
import com.fetchProject.demo.model.Receipt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

@Service
public class PointCalculator {
    public static int pointsCalculate(Receipt receipt) {
        int points = 0;

        //  alphanumeric characters in retailer name
        points += countAlphanumeric(receipt.getRetailer());

        // check if the total is a round dollar amount
        double total = Double.parseDouble(receipt.getTotal());
        if (total == Math.floor(total)) {
            points += 50;
        }

        //  check if the total is a multiple of 0.25
        if (total % 0.25 == 0) {
            points += 25;
        }

        //  Award 5 points for every two items
        points += (receipt.getItems().size() / 2) * 5;

        //  Award points based on item description length and price
        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                double price = Double.parseDouble(item.getPrice());
                points += Math.ceil(price * 0.2);
            }
        }

        // 6. Add points for odd purchase days
        LocalDate date = LocalDate.parse(receipt.getPurchaseDate());
        if (date.getDayOfMonth() % 2 != 0) {
            points += 6;
        }

        // 7. Add points for purchases between 2:00 PM and 4:00 PM
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        if (time.isAfter(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) {
            points += 10;
        }

        return points;
    }

    // Counts alphanumeric characters in a string
    private static int countAlphanumeric(String input) {
        return (int) Pattern.compile("[a-zA-Z0-9]").matcher(input).results().count();
    }
}

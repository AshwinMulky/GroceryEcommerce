package com.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.dto.ReceiptRequestDto;
import com.grocery.service.GroceryReceiptService;

@RestController
@RequestMapping("grocery")
public class GroceryReceiptController {

    @Autowired
    private GroceryReceiptService groceryReceiptService;
    
    @PostMapping("/receipt")
    public ResponseEntity<?> generateReceipt(@RequestBody ReceiptRequestDto receiptRequestDto) {
        return new ResponseEntity<>(groceryReceiptService.generateReceipt(receiptRequestDto), HttpStatus.OK);
    }
}

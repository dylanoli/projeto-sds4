package com.devsuperior.dsvendas.controller;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.dto.SellerSunDTO;
import com.devsuperior.dsvendas.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll(){
        var result = sellerService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/sum-by-seller")
    public ResponseEntity<List<SellerSunDTO>> amountGroupBySeller(){
        var result = sellerService.amountGroupBySeller();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller(){
        var result = sellerService.successGroupBySeller();
        return ResponseEntity.ok(result);
    }
    
}

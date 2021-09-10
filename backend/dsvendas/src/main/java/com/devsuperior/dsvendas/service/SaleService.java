package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;


import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    
    @Autowired
    private SellerRepository sellerRepository;

    public List<SaleDTO> findAll() {
        var result = saleRepository.findAll();
        return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        var result = saleRepository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }
}

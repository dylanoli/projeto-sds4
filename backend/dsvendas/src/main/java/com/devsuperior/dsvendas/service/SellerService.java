package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.dto.SellerSunDTO;
import com.devsuperior.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public List<SellerDTO> findAll() {
        var result = sellerRepository.findAll();
        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SellerSunDTO> amountGroupBySeller(){
       return sellerRepository.amountGroupBySeller();
    }    

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupBySeller() {
        return sellerRepository.successGroupBySeller();
    }
}

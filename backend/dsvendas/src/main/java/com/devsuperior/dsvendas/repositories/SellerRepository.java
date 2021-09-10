package com.devsuperior.dsvendas.repositories;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SellerSunDTO;
import com.devsuperior.dsvendas.entities.Seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    
    @Query("SELECT new com.devsuperior.dsvendas.dto.SellerSunDTO(obj.seller, SUM(obj.amount)) " 
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SellerSunDTO> amountGroupBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupBySeller();
}

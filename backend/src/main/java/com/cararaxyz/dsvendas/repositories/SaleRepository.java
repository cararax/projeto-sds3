package com.cararaxyz.dsvendas.repositories;

import com.cararaxyz.dsvendas.dto.SaleSuccessDTO;
import com.cararaxyz.dsvendas.dto.SaleSumDTO;
import com.cararaxyz.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.cararaxyz.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.cararaxyz.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))" +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();

}

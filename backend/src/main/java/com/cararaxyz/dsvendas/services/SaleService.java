package com.cararaxyz.dsvendas.services;

import com.cararaxyz.dsvendas.dto.SaleDTO;
import com.cararaxyz.dsvendas.entities.Sale;
import com.cararaxyz.dsvendas.repositories.SaleRepository;
import com.cararaxyz.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); //jpa armazena vendedores em cache para evitar interações repetidas com o bd

        Page<Sale> result = repository.findAll(pageable);

        return result.map(x -> new SaleDTO(x));

    }
}

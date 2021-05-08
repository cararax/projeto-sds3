package com.cararaxyz.dsvendas.services;

import com.cararaxyz.dsvendas.dto.SellerDTO;
import com.cararaxyz.dsvendas.entities.Seller;
import com.cararaxyz.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @GetMapping
    public List<SellerDTO> findAll(){
        List<Seller> result = repository.findAll();

        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }

}

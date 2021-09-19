package com.UDM.StockManager.service;

import com.UDM.StockManager.domain.Product;
import com.UDM.StockManager.domain.ProductCode;
import com.UDM.StockManager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockService {

    @Autowired
    private ProductRepo productRepo;

    public StockService(){}

    private Map<Enum, List<Product>> stockReport = new HashMap<>();



    public Product add ( Product product){

        Product newProduct = productRepo.save( product );

        return newProduct;
    }



}

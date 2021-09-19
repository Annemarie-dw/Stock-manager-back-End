package com.UDM.StockManager.repo;

import com.UDM.StockManager.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product,Long> {
}

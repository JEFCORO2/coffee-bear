package com.jcoronel.coffeebear.repository;

import com.jcoronel.coffeebear.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

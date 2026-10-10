package com.jcoronel.coffeebear.repository;

import com.jcoronel.coffeebear.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
}

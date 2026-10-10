package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.client.ProductRequestDto;
import com.jcoronel.coffeebear.dto.client.ProductResponseDto;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<ProductResponseDto> findAll(Integer page, Integer size);
    ProductResponseDto findById(Integer id);
    ProductResponseDto saveProduct(ProductRequestDto productRequestDto);
    ProductResponseDto updateProduct(Integer id , ProductRequestDto productRequestDto);
    void deleteProduct(Integer id);
}

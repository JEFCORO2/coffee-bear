package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.type.ProductTypeRequestDto;
import com.jcoronel.coffeebear.dto.type.ProductTypeResponseDto;
import org.springframework.data.domain.Page;

public interface ProductTypeService {
    Page<ProductTypeResponseDto> findAll(Integer page, Integer size);
    ProductTypeResponseDto findById(Integer id);
    ProductTypeResponseDto saveProductType(ProductTypeRequestDto productTypeRequestDto);
    ProductTypeResponseDto updateProductType(Integer id , ProductTypeRequestDto productTypeRequestDto);
    void deleteProductType(Integer id);
}

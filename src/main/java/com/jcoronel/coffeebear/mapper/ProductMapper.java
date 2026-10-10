package com.jcoronel.coffeebear.mapper;

import com.jcoronel.coffeebear.dto.client.ProductRequestDto;
import com.jcoronel.coffeebear.dto.client.ProductResponseDto;
import com.jcoronel.coffeebear.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto productToDto(Product product);
    Product dtoToProduct(ProductRequestDto productRequestDto);
}

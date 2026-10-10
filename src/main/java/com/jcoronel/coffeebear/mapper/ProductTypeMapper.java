package com.jcoronel.coffeebear.mapper;

import com.jcoronel.coffeebear.dto.type.ProductTypeRequestDto;
import com.jcoronel.coffeebear.dto.type.ProductTypeResponseDto;
import com.jcoronel.coffeebear.entity.ProductType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {
    ProductTypeResponseDto productTypeToDto(ProductType productType);
    ProductType dtoToProductType(ProductTypeRequestDto productTypeRequestDto);
}

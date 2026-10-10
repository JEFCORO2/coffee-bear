package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.type.ProductTypeRequestDto;
import com.jcoronel.coffeebear.dto.type.ProductTypeResponseDto;
import com.jcoronel.coffeebear.entity.ProductType;
import com.jcoronel.coffeebear.exception.ResourceNotFoundException;
import com.jcoronel.coffeebear.mapper.ProductTypeMapper;
import com.jcoronel.coffeebear.repository.ProductTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;

    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository, ProductTypeMapper productTypeMapper) {
        this.productTypeRepository = productTypeRepository;
        this.productTypeMapper = productTypeMapper;
    }

    @Override
    public Page<ProductTypeResponseDto> findAll(Integer page, Integer size) {
        //crear exepciones para validar page y size
        final Pageable pageable = PageRequest.of(page,size);
        return productTypeRepository.findAll(pageable).map(productTypeMapper::productTypeToDto);
    }

    @Override
    public ProductTypeResponseDto findById(Integer id) {
        return productTypeMapper.productTypeToDto(productTypeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ProductType.class.getSimpleName())));
    }

    @Override
    public ProductTypeResponseDto saveProductType(ProductTypeRequestDto productTypeRequestDto) {
        ProductType productType = productTypeMapper.dtoToProductType(productTypeRequestDto);
        productTypeRepository.save(productType);
        return productTypeMapper.productTypeToDto(productType);
    }

    @Override
    @Transactional
    public ProductTypeResponseDto updateProductType(Integer id, ProductTypeRequestDto productTypeRequestDto) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ProductType.class.getSimpleName()));

        productType.setName(productTypeRequestDto.getName());
        productType.setEnabled(productTypeRequestDto.getEnabled());

        return productTypeMapper.productTypeToDto(productType);
    }

    @Override
    public void deleteProductType(Integer id) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ProductType.class.getSimpleName()));
        productTypeRepository.delete(productType);
    }
}

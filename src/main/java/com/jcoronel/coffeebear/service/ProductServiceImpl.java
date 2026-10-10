package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.client.ProductRequestDto;
import com.jcoronel.coffeebear.dto.client.ProductResponseDto;
import com.jcoronel.coffeebear.entity.Product;
import com.jcoronel.coffeebear.exception.ResourceNotFoundException;
import com.jcoronel.coffeebear.mapper.ProductMapper;
import com.jcoronel.coffeebear.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Page<ProductResponseDto> findAll(Integer page, Integer size) {
        //crear exepciones para validar page y size
        final Pageable pageable = PageRequest.of(page,size);
        return productRepository.findAll(pageable).map(productMapper::productToDto);
    }

    @Override
    public ProductResponseDto findById(Integer id) {
        return productMapper.productToDto(productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Product.class.getSimpleName())));
    }

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.dtoToProduct(productRequestDto);
        productRepository.save(product);
        return productMapper.productToDto(product);
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(Integer id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Product.class.getSimpleName()));

        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setType(productRequestDto.getType());
        product.setPrice(productRequestDto.getPrice());
        
        return productMapper.productToDto(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Product.class.getSimpleName()));
        productRepository.delete(product);
    }
}

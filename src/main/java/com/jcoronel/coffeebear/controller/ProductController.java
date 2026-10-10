package com.jcoronel.coffeebear.controller;

import com.jcoronel.coffeebear.dto.ApiResponse;
import com.jcoronel.coffeebear.dto.client.ProductRequestDto;
import com.jcoronel.coffeebear.dto.client.ProductResponseDto;
import com.jcoronel.coffeebear.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok().body(productService.findAll(page,size));
    }

    //validar que solo sean numeros
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> save(@Valid @RequestBody ProductRequestDto productRequestDto){
        return  ResponseEntity.ok().body(productService.saveProduct(productRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Integer id, @Valid @RequestBody ProductRequestDto productRequestDto){
        return  ResponseEntity.ok().body(productService.updateProduct(id,productRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "Product successfully deleted",null));
    }
}

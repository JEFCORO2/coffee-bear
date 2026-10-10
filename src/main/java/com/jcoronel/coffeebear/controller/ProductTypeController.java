package com.jcoronel.coffeebear.controller;

import com.jcoronel.coffeebear.dto.ApiResponse;
import com.jcoronel.coffeebear.dto.type.ProductTypeRequestDto;
import com.jcoronel.coffeebear.dto.type.ProductTypeResponseDto;
import com.jcoronel.coffeebear.service.ProductTypeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products-types")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductTypeResponseDto>> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok().body(productTypeService.findAll(page,size));
    }

    //validar que solo sean numeros
    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeResponseDto> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(productTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductTypeResponseDto> save(@Valid @RequestBody ProductTypeRequestDto productTypeRequestDto){
        return  ResponseEntity.ok().body(productTypeService.saveProductType(productTypeRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeResponseDto> update(@PathVariable Integer id, @Valid @RequestBody ProductTypeRequestDto productTypeRequestDto){
        return  ResponseEntity.ok().body(productTypeService.updateProductType(id,productTypeRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        productTypeService.deleteProductType(id);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "ProductType successfully deleted",null));
    }
}

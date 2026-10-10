package com.jcoronel.coffeebear.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDto {
    @NotBlank
    private String name;

    private String description;

    private Double price;

    @NotNull
    private Integer type;

    public ProductRequestDto(String name, String description, Double price, Integer type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public ProductRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

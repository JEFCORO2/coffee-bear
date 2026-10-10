package com.jcoronel.coffeebear.dto.client;

public class ProductResponseDto {
    private Integer id;
    private String name;
    private String description;
    private Integer type;
    private Double price;

    public ProductResponseDto() {
    }

    public ProductResponseDto(Integer id, String name, String description, Integer type, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

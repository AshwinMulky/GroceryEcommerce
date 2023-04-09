package com.grocery.dto;

import lombok.Data;

@Data
public class ItemDto {
    
    private int sku;

    private String itemName;

    private boolean taxable;

    private boolean ownBrand;

    private double price;

}

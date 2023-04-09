package com.grocery.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReceiptRequestDto {
    
    private List<ItemDto> items;
}

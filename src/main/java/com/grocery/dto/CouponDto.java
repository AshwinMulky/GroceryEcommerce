package com.grocery.dto;

import lombok.Data;

@Data
public class CouponDto {
    
    private int appliedSku;

    private String couponName;

    private double discountPrice;

    public CouponDto(int appliedSku, String couponName, double discountPrice) {
        this.appliedSku = appliedSku;
        this.couponName = couponName;
        this.discountPrice = discountPrice;
    }
    
}

package com.grocery.dto;

import lombok.Data;

@Data
public class ReceiptResponseDto {
    
    private double subtotalBeforeDiscounts;

    private double discountTotal;

    private double subtotalAfterDiscounts;

    private double taxableSubtotalAfterDiscounts;

    private double taxTotal;

    private double grandTotal;

    public double getSubtotalBeforeDiscounts() {
        return Math.round(this.subtotalBeforeDiscounts * 100) / 100.0;
    }

    public double getDiscountTotal() {
        return Math.round(this.discountTotal * 100) / 100.0;
    }

    public double getSubtotalAfterDiscounts() {
        return Math.round(this.subtotalAfterDiscounts * 100) / 100.0;
    }

    public double getTaxableSubtotalAfterDiscounts() {
        return Math.round(this.taxableSubtotalAfterDiscounts * 100) / 100.0;
    }

    public double getTaxTotal() {
        return Math.round(this.taxTotal * 100) / 100.0;
    }

    public double getGrandTotal() {
        return Math.round(this.grandTotal * 100) / 100.0;
    }
}

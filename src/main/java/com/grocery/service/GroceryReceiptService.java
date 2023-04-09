package com.grocery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.dto.CouponDto;
import com.grocery.dto.ItemDto;
import com.grocery.dto.ReceiptRequestDto;
import com.grocery.dto.ReceiptResponseDto;
import com.grocery.utils.CouponUtils;

@Service
public class GroceryReceiptService {

    @Autowired
    private CouponUtils couponUtils;

    public ReceiptResponseDto generateReceipt(ReceiptRequestDto receiptRequestDto) {
        ReceiptResponseDto receiptResponseDto = new ReceiptResponseDto();
        receiptResponseDto.setSubtotalBeforeDiscounts(calculateSubTotal(receiptRequestDto.getItems()));
        receiptResponseDto.setDiscountTotal(0.0);
        receiptResponseDto.setTaxTotal(0.0);

        List<ItemDto> finalItems = receiptRequestDto.getItems().stream().map(item -> {
             //Discount
            if(couponUtils.contains(item.getSku())) {
                CouponDto coupon = couponUtils.getCoupon(item.getSku());
                //The final price of an item cannot be negative.
                //If price becomes negative - discount will be same as price and price becomes zero
                if(item.getPrice() - coupon.getDiscountPrice() < 0) {
                    receiptResponseDto.setDiscountTotal(receiptResponseDto.getDiscountTotal() + item.getPrice());
                    item.setPrice(0.0);
                } else {
                    receiptResponseDto.setDiscountTotal(receiptResponseDto.getDiscountTotal() + coupon.getDiscountPrice());
                    item.setPrice(item.getPrice() - coupon.getDiscountPrice());
                }
            }
           return item;
        })
        .map(item -> {
            //Tax
            if(item.isTaxable()){
                receiptResponseDto.setTaxTotal(receiptResponseDto.getTaxTotal() + (item.getPrice() * 0.0825));
            }
            return item;
        })
        .collect(Collectors.toList());

        receiptResponseDto.setSubtotalAfterDiscounts(calculateSubTotal(finalItems));
        receiptResponseDto.setTaxableSubtotalAfterDiscounts(calculateSubTotal(finalItems.stream().filter(item -> item.isTaxable()).collect(Collectors.toList())));
        receiptResponseDto.setGrandTotal(receiptResponseDto.getSubtotalAfterDiscounts() + receiptResponseDto.getTaxTotal());
        return receiptResponseDto;
    }

    private double calculateSubTotal(List<ItemDto> items) {
        return items.stream().mapToDouble(item -> item.getPrice()).sum();
    }
    
}

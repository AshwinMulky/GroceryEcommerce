package com.grocery.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.grocery.dto.CouponDto;

@Component
public class CouponUtils {

    private Map<Integer, CouponDto> couponRepositoryMap = new HashMap<>();

    public CouponUtils() {
        couponRepositoryMap.put(85294241, new CouponDto(85294241, "Brownie Discount", 0.79));
        couponRepositoryMap.put(61411728, new CouponDto(61411728, "Tofurky Discount", 1.01));
        couponRepositoryMap.put(30532705, new CouponDto(30532705, "Spaghetti Discount", 1.83));
        couponRepositoryMap.put(21411389, new CouponDto(21411389, "Seafood Discount", 1.50));
    }

    public boolean contains(int sku) {
        return couponRepositoryMap.containsKey(sku);
    }

    public CouponDto getCoupon(int sku) {
        return couponRepositoryMap.get(sku);
    }
    
}

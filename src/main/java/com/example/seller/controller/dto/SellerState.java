package com.example.seller.controller.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum SellerState {
    SELLER_UNAVAILABLE, AVAILABLE_SELLER;

    private static final List<SellerState> VALUES = Arrays.asList(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static SellerState randomState() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}

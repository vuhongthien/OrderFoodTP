package com.bees.OrderFood.utils;

public class TotalPriceUtils {
    public static double TotalPrice(double price, int quantity) {
        return  price * quantity;
    }
    public static double TotalPriceCart(int x, float y) {
        return  x * y;
    }
}

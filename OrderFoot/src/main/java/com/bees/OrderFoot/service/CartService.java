package com.bees.OrderFoot.service;

import com.bees.OrderFoot.dto.CartDto;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CartService {
     Map<Long, CartDto> AddCart(CartDto cartDto);

     Map<Long, CartDto> EditCart(long id,int quanty);

     Map<Long, CartDto> DeleteCart(long id);
     Collection<CartDto> showall();

     int TotalQuanty();

     double TotalPrice();
}

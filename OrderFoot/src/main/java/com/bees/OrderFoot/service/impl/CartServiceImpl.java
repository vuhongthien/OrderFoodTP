package com.bees.OrderFoot.service.impl;

import com.bees.OrderFoot.dto.CartDto;
import com.bees.OrderFoot.dto.DishDto;
import com.bees.OrderFoot.service.CartService;
import com.bees.OrderFoot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
    @Autowired
    DishService dishService;
    Map<Long, CartDto> cart = new HashMap<>();
    @Override
    public Map<Long, CartDto> AddCart(CartDto cartDto ) {

        CartDto itemCart = new CartDto();
        DishDto dishDto = dishService.findByIdDto(cartDto.getDishId());
        if(dishDto != null && cart.containsKey(cartDto.getDishId())) {
            itemCart = cart.get(cartDto.getDishId());
            itemCart.setQuanty(itemCart.getQuanty() + 1);
            itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getDishDto().getPrice());

        }
        else {
            itemCart.setDishDto(dishDto);
            itemCart.setQuanty(1);
            itemCart.setTotalPrice(dishDto.getPrice());
        }
        cart.put(cartDto.getDishId(), itemCart);
        return cart;
    }

    @Override
    public HashMap<Long, CartDto> EditCart(long id, int quanty) {
        return null;
    }

    @Override
    public HashMap<Long, CartDto> DeleteCart(long id) {
        return null;
    }

    @Override
    public Collection<CartDto> showall() {
        return cart.values();
    }

    @Override
    public int TotalQuanty() {
        return 0;
    }

    @Override
    public double TotalPrice() {
        return 0;
    }
}

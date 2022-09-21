package com.bees.OrderFoot.controller.user;

import com.bees.OrderFoot.dto.CartDto;
import com.bees.OrderFoot.dto.DishDto;
import com.bees.OrderFoot.service.impl.CartServiceImpl;
import com.bees.OrderFoot.service.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    DishServiceImpl dishService;
    @PostMapping(value = "/add-cart")
    public Map<Long, CartDto> addcart(
                                      @RequestParam("dishid") Long dishid) {
        DishDto dishDto = dishService.findByIdDto(dishid);
           CartDto cartDto = new CartDto();
           cartDto.setDishId(dishDto.getDishId());
           cartDto.setQuanty(1);
           cartDto.setTotalPrice(dishDto.getPrice());
        return cartService.AddCart(cartDto);
    }
    @GetMapping(value = "/get-cart")
    public Collection<CartDto> getallcart() {
        return cartService.showall();
    }
}

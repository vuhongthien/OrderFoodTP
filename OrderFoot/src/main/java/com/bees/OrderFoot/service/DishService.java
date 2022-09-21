package com.bees.OrderFoot.service;

import com.bees.OrderFoot.model.Dish;
import com.bees.OrderFoot.model.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface DishService {
    Page<Dish> findAllDish(Pageable pageable);
    Dish create(Dish dish);
    Dish findById(Long id);
    void delete(Long id);

}

package com.bees.OrderFoot.service.impl;

import com.bees.OrderFoot.model.Dish;
import com.bees.OrderFoot.repository.DishRepository;
import com.bees.OrderFoot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;
    @Override
    public Page<Dish> findAllDish(Pageable pageable) {
        return dishRepository.findAll(pageable);
    }

    @Override
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}
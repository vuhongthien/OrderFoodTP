package com.bees.OrderFood.service;

import com.bees.OrderFood.model.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DishTypeService {
    Page<DishType> findAllDishType(Pageable pageable);
    DishType create(DishType dishType);
    DishType findById(Long id);
    void delete(Long id);

}

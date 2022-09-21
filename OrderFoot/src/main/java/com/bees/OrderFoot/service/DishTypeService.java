package com.bees.OrderFoot.service;

import com.bees.OrderFoot.model.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface DishTypeService {
    Page<DishType> findAllDishType(Pageable pageable);
    DishType create(DishType dishType);
    DishType findById(Long id);
    void delete(Long id);

}

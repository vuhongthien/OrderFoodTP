package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.model.DishType;
import com.bees.OrderFood.repository.DishTypeRepository;
import com.bees.OrderFood.service.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishTypeServiceImpl implements DishTypeService {
    @Autowired
    private DishTypeRepository dishTypeRepository;

    @Override
    public Page<DishType> findAllDishType(Pageable pageable) {
        return dishTypeRepository.findAll(pageable);
    }

    @Override
    public DishType create(DishType dishType) {
        return dishTypeRepository.save(dishType);
    }

    @Override
    public DishType findById(Long id) {
        return dishTypeRepository.findById(id).get();
    }


    @Override
    public void delete(Long id) {
        dishTypeRepository.deleteById(id);
    }
}

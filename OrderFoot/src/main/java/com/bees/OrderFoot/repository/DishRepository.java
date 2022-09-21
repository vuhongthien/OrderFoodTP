package com.bees.OrderFoot.repository;

import com.bees.OrderFoot.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {
}

package com.bees.OrderFoot.repository;

import com.bees.OrderFoot.model.DishType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishTypeRepository extends JpaRepository<DishType, Long> {
}

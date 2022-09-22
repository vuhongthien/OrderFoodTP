package com.bees.OrderFoot.controller.admin;

import com.bees.OrderFoot.model.DishType;
import com.bees.OrderFoot.service.impl.DishTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DishTypeController {
    @Autowired
    DishTypeServiceImpl dishTypeService;
    @GetMapping("/list-dish-type/{pageNumber}/{pageSize}")
    public Page<DishType> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                                  @PathVariable(name = "pageSize") Integer pageSize){
        return dishTypeService.findAllDishType(PageRequest.of(pageNumber,pageSize));
    }
    @PostMapping("/add-dish-type")
    public DishType adddishtype(@RequestParam("TypeDishName") String TypeDishName){
        DishType dishType = new DishType();
        dishType.setTypeDishName(TypeDishName);
        dishType.setActive(1);
        return dishTypeService.create(dishType);
    }
    @PutMapping("/edit-dish-type")
    public DishType editdishtype(@RequestParam("TypeDishName") String TypeDishName,
                                @RequestParam("Active")int Active,
                                @RequestParam("id") Long id){
        DishType dishType = dishTypeService.findById(id);
        dishType.setTypeDishName(TypeDishName);
        dishType.setActive(Active);
        return dishTypeService.create(dishType);
    }
    @DeleteMapping("/drop-dish-type")
    public ResponseEntity dropdishtype(@RequestParam("id") Long id){
         dishTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

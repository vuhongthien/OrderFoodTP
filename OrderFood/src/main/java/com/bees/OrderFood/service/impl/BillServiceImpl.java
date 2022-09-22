package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.dto.CartDto;
import com.bees.OrderFood.exception.DonFoundItemCart;
import com.bees.OrderFood.exception.NotEnoughQuantity;
import com.bees.OrderFood.model.Bill;
import com.bees.OrderFood.model.DetailBill;
import com.bees.OrderFood.model.Dish;
import com.bees.OrderFood.repository.BillRepository;
import com.bees.OrderFood.repository.DetailBillRepository;
import com.bees.OrderFood.service.BillService;
import com.bees.OrderFood.status.StatusCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bees.OrderFood.utils.TotalPriceUtils.TotalPrice;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    DetailBillSerViceImpl detailBillSerVice;
    @Autowired
    DetailBillRepository detailBillRepository;
    @Autowired
    DishServiceImpl dishService;
    @Autowired
    CartServiceImpl cartService;
    Map<Long, CartDto> cart = new HashMap<>();

    @Override
    public Page<Bill> findAllBill(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public List<Bill> listAll() {
        return billRepository.findAll();

    }

    @Override
    public Bill create(Bill bill, DetailBill detailBill) {
        Bill b = new Bill();
        b.setDaySet(LocalDateTime.now());
        b.setUserId(bill.getUserId());
        Bill b2 = billRepository.save(b);
        Collection<CartDto> c = cartService.showall();
        if(c==null){
            try {
                throw new DonFoundItemCart(String.format(
                        StatusCart.ITEM_CART_NOT_FOUND + c));
            } catch (DonFoundItemCart e) {
                throw new RuntimeException(e);
            }
        }
        Double acc = 0.0;
        for(CartDto x : c){
            DetailBill newDetailBill = new DetailBill();
            newDetailBill.setBillId(b2.getBillId());
            newDetailBill.setPrice(x.getDishDto().getPrice());
            newDetailBill.setQuantity(x.getQuanty());
            newDetailBill.setImage(x.getDishDto().getImage());
            newDetailBill.setTotalPrice(TotalPrice(x.getDishDto().getPrice(),x.getQuanty()));
            newDetailBill.setDishId(x.getDishId());
            Dish dish = dishService.findById(x.getDishId());
            dish.setBought(dish.getBought() + x.getQuanty());
            dish.setQuantity(dish.getQuantity()  - x.getQuanty());
            if(dish.getQuantity()>=0){
                dishService.create(dish);
                detailBillRepository.save(newDetailBill);
                Double totalPrice = x.getTotalPrice();
                acc = acc + totalPrice;
            }else {
                try {
                    billRepository.deleteById(b2.getBillId());
                    throw new NotEnoughQuantity(String.format( StatusCart.NOT_ENOUGH_QUATITY_IN_CART));

                } catch (NotEnoughQuantity e) {
                    throw new RuntimeException(e);
                }

            }

        }
        Double sum = acc;
        b2.setTotalPrice(sum);
        return billRepository.save(b2);
    }

    @Override
    public Bill findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

package com.bees.OrderFoot.service.impl;

import com.bees.OrderFoot.model.Bill;
import com.bees.OrderFoot.model.DetailBill;
import com.bees.OrderFoot.model.Dish;
import com.bees.OrderFoot.repository.BillRepository;
import com.bees.OrderFoot.repository.DetailBillRepository;
import com.bees.OrderFoot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.bees.OrderFoot.utils.TotalPriceUtils.TotalPrice;

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
        Dish dish = dishService.findById(detailBill.getDishId());
        DetailBill newDetailBill = new DetailBill();
        newDetailBill.setBillId(b2.getBillId());
        newDetailBill.setPrice(dish.getPrice());
        newDetailBill.setQuantity(detailBill.getQuantity());
        newDetailBill.setImage(dish.getImage());
        newDetailBill.setTotalPrice(TotalPrice(dish.getPrice(),detailBill.getQuantity()));
        newDetailBill.setDishId(detailBill.getDishId());
        DetailBill detailBill1=detailBillRepository.save(newDetailBill);
        List<DetailBill> list = detailBillSerVice.findByBillId(b2.getBillId());
        Double acc = Double.valueOf(0);
        for (DetailBill x : list) {
            Double totalPrice = x.getTotalPrice();
            acc = acc + totalPrice;
        }
        Double sum = acc;
        Bill bill1 = billRepository.findById(detailBill1.getBillId()).get();
        bill1.setTotalPrice(sum);
        return billRepository.save(bill1);
    }

    @Override
    public Bill findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

package com.bees.OrderFoot.service;

import com.bees.OrderFoot.model.Bill;
import com.bees.OrderFoot.model.DetailBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BillService {
    Page<Bill> findAllBill(Pageable pageable);
    List<Bill> listAll();
    Bill create(Bill bill, DetailBill detailBill);
    Bill findById(Long id);
    void delete(Long id);
}

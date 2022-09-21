package com.bees.OrderFoot.controller.admin;

import com.bees.OrderFoot.model.Bill;
import com.bees.OrderFoot.model.DetailBill;
import com.bees.OrderFoot.service.impl.BillServiceImpl;
import com.bees.OrderFoot.service.impl.DetailBillSerViceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    BillServiceImpl billService;
    @PostMapping("/add-bill")
    public Bill addbill(@RequestParam("dish_id") Long dishid,
                              @RequestParam("user_id") Long userid,
                              @RequestParam("detail_bill_quantity") int detailbillquantity
                                    ){
        Bill bill = new Bill();
        bill.setDaySet(LocalDateTime.now());
        bill.setUserId(userid);
        DetailBill detailBill = new DetailBill();
        detailBill.setDishId(dishid);
        detailBill.setQuantity(detailbillquantity);
        return billService.create(bill, detailBill);
    }
    @GetMapping("/list-bill/{pageNumber}/{pageSize}")
    public Page<Bill> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                                    @PathVariable(name = "pageSize") Integer pageSize){
        return billService.findAllBill(PageRequest.of(pageNumber,pageSize));
    }
    @GetMapping("/list-bill")
    public List<Bill> listallbill(){
        return billService.listAll();
    }
}

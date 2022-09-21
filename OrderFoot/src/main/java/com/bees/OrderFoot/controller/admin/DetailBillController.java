package com.bees.OrderFoot.controller.admin;

import com.bees.OrderFoot.model.DetailBill;
import com.bees.OrderFoot.service.impl.DetailBillSerViceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetailBillController {
    @Autowired
    DetailBillSerViceImpl detailBillSerVice;
    @GetMapping("/list-detail-bill/{pageNumber}/{pageSize}")
    public Page<DetailBill> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                                    @PathVariable(name = "pageSize") Integer pageSize){
        return detailBillSerVice.findAllDetailBill(PageRequest.of(pageNumber,pageSize));
    }
    @GetMapping("/list-detail-bill")
    public List<DetailBill> listalldetailbill(@RequestParam("idbill") Long id){
        return detailBillSerVice.findByBillId(id);
    }

    @DeleteMapping("/drop-detail-bill")
    public ResponseEntity dropdetailbill(@RequestParam("id") Long id){
        detailBillSerVice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.bees.OrderFoot.service;

import com.bees.OrderFoot.model.Image;
import com.bees.OrderFoot.model.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VoucherService {
    Page<Voucher> findAllImage(Pageable pageable);
    Voucher create(Voucher voucher);
    Voucher findById(Long id);
    void delete(Long id);
}

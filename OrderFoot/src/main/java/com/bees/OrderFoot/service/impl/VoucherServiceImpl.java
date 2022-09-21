package com.bees.OrderFoot.service.impl;

import com.bees.OrderFoot.model.Voucher;
import com.bees.OrderFoot.repository.VoucherRepository;
import com.bees.OrderFoot.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public Page<Voucher> findAllImage(Pageable pageable) {
        return voucherRepository.findAll(pageable);
    }

    @Override
    public Voucher create(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public Voucher findById(Long id) {
        return voucherRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        voucherRepository.deleteById(id);
    }
}

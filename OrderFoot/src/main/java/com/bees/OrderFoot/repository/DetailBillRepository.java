package com.bees.OrderFoot.repository;

import com.bees.OrderFoot.model.DetailBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface DetailBillRepository extends JpaRepository<DetailBill, Long> {
    @Query(value = "SELECT * " +
            "FROM of.tbl_detail_bill a " +
            "WHERE a.bill_id =:billid", nativeQuery = true)
    List<DetailBill> findByBillId(@Param("billid") Long billid);
}

package com.bees.OrderFoot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long BillId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User User;
    @Column(name = "bill_day_set")
    private LocalDateTime DaySet;
    @Column(name = "bill_total_price")
    private float TotalPrice;

    public Bill(Long billId, com.bees.OrderFoot.model.User user, LocalDateTime daySet, float totalPrice) {
        BillId = billId;
        User = user;
        DaySet = daySet;
        TotalPrice = totalPrice;
    }


    public Bill() {
    }

    public Long getBillId() {
        return BillId;
    }

    public void setBillId(Long billId) {
        BillId = billId;
    }

    public com.bees.OrderFoot.model.User getUser() {
        return User;
    }

    public void setUser(com.bees.OrderFoot.model.User user) {
        User = user;
    }

    public LocalDateTime getDaySet() {
        return DaySet;
    }

    public void setDaySet(LocalDateTime daySet) {
        DaySet = daySet;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }
}

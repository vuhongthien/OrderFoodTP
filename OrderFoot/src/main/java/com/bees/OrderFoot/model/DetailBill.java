package com.bees.OrderFoot.model;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_detail_bill")
public class DetailBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_bill_id")
    private Long DetailBillId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    @ToString.Exclude
    private Dish Dish;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    @ToString.Exclude
    private Bill Bill;
    @Column(name = "detail_bill_quantity")
    private int Quantity;
    @Column(name = "detail_bill_total_price")
    private float TotalPrice;
    @Column(name = "detail_bill_image")
    private String Image;

    public DetailBill(Long detailBillId, com.bees.OrderFoot.model.Dish dish, com.bees.OrderFoot.model.Bill bill, int quantity, float totalPrice, String image) {
        DetailBillId = detailBillId;
        Dish = dish;
        Bill = bill;
        Quantity = quantity;
        TotalPrice = totalPrice;
        Image = image;
    }

    public DetailBill() {
    }

    public Long getDetailBillId() {
        return DetailBillId;
    }

    public void setDetailBillId(Long detailBillId) {
        DetailBillId = detailBillId;
    }

    public com.bees.OrderFoot.model.Dish getDish() {
        return Dish;
    }

    public void setDish(com.bees.OrderFoot.model.Dish dish) {
        Dish = dish;
    }

    public com.bees.OrderFoot.model.Bill getBill() {
        return Bill;
    }

    public void setBill(com.bees.OrderFoot.model.Bill bill) {
        Bill = bill;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

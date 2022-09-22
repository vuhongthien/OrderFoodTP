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
    @ManyToOne(optional=false)
    @JoinColumn(name = "dish_id", insertable=false, updatable=false)
    private Dish Dish;
    @Column(name = "dish_id")
    private Long DishId;
    @ManyToOne(optional=false)
    @JoinColumn(name = "bill_id", insertable=false, updatable=false)
    private Bill Bill;
    @Column(name = "bill_id")
    private Long BillId;
    @Column(name = "detail_bill_quantity")
    private int Quantity;
    @Column(name = "detail_bill_price")
    private double Price;
    @Column(name = "detail_bill_total_price")
    private double TotalPrice;
    @Column(name = "detail_bill_image")
    private String Image;

    public DetailBill(Long detailBillId, com.bees.OrderFoot.model.Dish dish, Long dishId, com.bees.OrderFoot.model.Bill bill, Long billId, int quantity, double price, double totalPrice, String image) {
        DetailBillId = detailBillId;
        Dish = dish;
        DishId = dishId;
        Bill = bill;
        BillId = billId;
        Quantity = quantity;
        Price = price;
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

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
    }

    public Long getBillId() {
        return BillId;
    }

    public void setBillId(Long billId) {
        BillId = billId;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}

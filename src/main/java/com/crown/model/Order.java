package com.crown.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @Column(name = "orderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    @NotNull
    private int productID;
    private int units;
    @ManyToOne
    @JoinColumn(name="orderID", nullable=false)
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    @OneToOne
    @JoinTable(name = "Product", joinColumns = @JoinColumn(name = "productID"), inverseJoinColumns = @JoinColumn(name = "productId"))
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}

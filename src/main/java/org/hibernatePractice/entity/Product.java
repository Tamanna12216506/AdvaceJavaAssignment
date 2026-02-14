package org.hibernatePractice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private  long id;

    @Column(name = "Product_Name", nullable = false)
    private  String name;
    @Column(name = "Product_Desc",length = 255)
    private  String desc;
    @Column(name ="Product_Category",nullable = false,length = 100)
    private  String category;
    @Column(name = "Product_Quantity", nullable = false)
    private int quantity;
    @Column(name="Product_Price",nullable = false)
    private  double price;
    @Column(name="Unique_Sku",nullable = false,unique = true)
    private  String sku;
    @Column(name="Product_Available")
    private  boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public  String toString(){
        return  id+" "+name+" "+desc+" "+category+" "+price+" "+quantity+" "+sku+" "+active;
    }


}

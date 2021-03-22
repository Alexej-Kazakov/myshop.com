package com.example.myshop.domain;


import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "Поле не может быть пустым")
    private String productName;
    private String productSize;


    private int quantity;
    @NotBlank(message = "Поле не может быть пустым")
    private String productPrice;
    @NotBlank(message = "Поле не может быть пустым")
    @URL(message = "Не правильный формат")
    private String productLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;



    public Product() {
    }


    public Product( String productName, String productSize, int quantity, String productPrice, String productLink , User customer) {
        this.productName = productName;
        this.productSize = productSize;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.productLink = productLink;
        this.customer = customer;
    }

    public String getCustomerName(){
        return customer != null ? customer.getUsername() : "<покупатель не найден>";
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }


}

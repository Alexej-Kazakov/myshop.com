package com.example.myshop.domain;


import org.hibernate.validator.constraints.URL;


import javax.persistence.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;;
import javax.validation.constraints.NotBlank;
import java.io.IOException;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "Поле не может быть пустым")
    private String productName;
    private String productSize;
    private  String photo;
    private int quantity;

    private Double productPrice;
    @NotBlank(message = "Поле не может быть пустым")
    @URL(message = "Не правильный формат")
    private String productLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;



    public Product() {
    }


    public Product( String productName, String photo, String productSize, int quantity, Double productPrice, String productLink , User customer) {
        this.productName = productName;
        this.photo = photo;
        this.productSize = productSize;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.productLink = productLink;
        this.customer = customer;
    }

    public Product link(String link) throws IOException {



        Document page = Jsoup.parse(new java.net.URL(link),10000);


        Element cart = page.select("div[class = card-fulldesktop]").first();
        String name = cart.select("h1[class = cart_information_title]").first().text();
       // String art = cart.select("span[class=card-article_text]").first().text();
        Element relHref = page.select("li[class = cart_foto_list_item productCard__active]").first();
        String  photo= relHref.select("a").attr("href");

        // System.out.println(relHref);

        String[] price = cart.select("span[class=cart_information_list_item__new]").first().ownText().split(" ");

        Double price1 = Double.parseDouble(price[0]);

        Product product = new Product(name, photo, "", 1, price1, link, customer);

        return product;
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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", photo='" + photo + '\'' +
                ", productSize='" + productSize + '\'' +
                ", quantity=" + quantity +
                ", productPrice='" + productPrice + '\'' +
                ", productLink='" + productLink + '\'' +
                '}';
    }


}

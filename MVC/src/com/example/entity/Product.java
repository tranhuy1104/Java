package com.example.entity;





public class Product {

    private Integer productId;
    private String productName;
    private String productDesc;
    private Double productPrice;

    public Product(){
    }

    public Product(String productName, String productDesc, Double productPrice){
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public Integer getProductId(){
        return productId;
    }

    public void setProductId(Integer productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }
}

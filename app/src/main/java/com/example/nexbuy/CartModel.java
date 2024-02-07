package com.example.nexbuy;

public class CartModel {
    private String cartId;
    private String prodName;
    private String prodImg;
    private String prodPrice;
    private String prodQty;
    private String sellerUid;
    public boolean is_selected;

    public String orderNumber;

    public CartModel() {
    }

    public CartModel(String cartId, String prodName, String prodImg, String prodPrice, String prodQty, String sellerUid, String orderNumber) {
        this.cartId = cartId;
        this.prodName = prodName;
        this.prodImg = prodImg;
        this.prodPrice = prodPrice;
        this.prodQty = prodQty;
        this.sellerUid = sellerUid;
        this.orderNumber = orderNumber;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdImg() {
        return prodImg;
    }

    public void setProdImg(String prodImg) {
        this.prodImg = prodImg;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProdQty() {
        return prodQty;
    }

    public void setProdQty(String prodQty) {
        this.prodQty = prodQty;
    }

    public String getSellerUid() {
        return sellerUid;
    }

    public void setSellerUid(String sellerUid) {
        this.sellerUid = sellerUid;
    }
}

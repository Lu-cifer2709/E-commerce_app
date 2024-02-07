package com.example.nexbuy;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private String id;
    private String title;
    private String desc;
    private String img;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;
    private boolean show;

    public ProductModel() {
    }

    public ProductModel(String id, String title, String desc, String img, String price, boolean show) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.price = price;
        this.show = show;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}

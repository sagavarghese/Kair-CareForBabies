package com.example.kair_careforbabies.Model;

public class Products {
private String pdtname,description,image,pid,category,date,time,price;

public Products(){

}

    public Products(String pdtname,String price, String description, String image, String pid, String category, String date, String time) {
        this.pdtname = pdtname;
        this.description = description;
        this.image = image;
        this.pid = pid;
        this.category = category;
        this.date = date;
        this.time = time;
        this.price = price;

    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPdtname() {
        return pdtname;
    }

    public void setPdtname(String pdtname) {
        this.pdtname = pdtname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

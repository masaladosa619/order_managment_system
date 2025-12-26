package model;

public class Product {
    private int prodcutId;
    private String productname;
    private double price;
    private int stock;


    public Product(int prodcutId,String productname,double price,int stock){
        this.prodcutId=prodcutId;
        this.price=price;
        this.productname=productname;
        this.stock=stock;
    }
    public String toString(){
        return prodcutId + " | " + productname + " | ₹" + price + " | Stock: " + stock;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }
}

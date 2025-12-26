package model;

import Service.OrderService;
import dao.ProductDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;

public class Customer extends user {

    public Customer(int userid){
        super(userid);
    }
    @Override
    public void showMenu() throws SQLException {
        System.out.println("===== CUSTOMER MENU =====");
        System.out.println("1. View Products");
        System.out.println("2. Place Order");
        System.out.println("3. Logout");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice:");
        int choice = sc.nextInt();


        if(choice==1){
            ProductDAO pd = new ProductDAO();
            List<Product> products = pd.getAllproducts();

            System.out.println("\n--- Available Products ---");
            for (Product p : products) {
                System.out.println(p); // Uses your custom toString() from image 1
            }
        }
        else if (choice==2) {
            OrderService orderservice = new OrderService();
            System.out.print("Enter Product ID: ");
            int productId = sc.nextInt();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();


            orderservice.placeorder(
                    user.getuser(),   // logged-in customer
                    productId,
                    quantity
            );
        } else if (choice==3) {
            System.out.println("Logging out");
        }
        else{
            System.out.println("Invalid Choice");
        }
    }
    }


package model;

import Service.OrderService;
import dao.orderDAO;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Employee extends user {
    public Employee(int userid) {
        super(userid);
    }

    @Override
    public void showMenu() {
        System.out.println("===== EMPLOYEE MENU =====");
        System.out.println("1. View Orders");
        System.out.println("2. Update Order Status");
        System.out.println("3.Cancel Order");
        System.out.println("4. Logout");

        System.out.println("ENTER YOUR CHOICE:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        OrderService orderService = new OrderService();

        try{

        if(choice==1){
            orderService.showAllOrders();
        } else if (choice==2) {

            System.out.println("PLEASE ENTER YOUR ORDER ID:");
            int orderid = sc.nextInt();


            System.out.println("ENTER NEW STATUS (PLACED/SHIPPED/DELIVERED)");
            String status = sc.next();
            orderService.changeOrderStatus(orderid,status);

        } else if (choice==3) {
            orderDAO orderDAO = new orderDAO();
            int orderid = sc.nextInt();
            System.out.println("IF YOU WANNA CANCEL YOUR ORDER PLS ENTER YOUR ORDER ID:" +orderid );
            orderDAO.ordercancel(orderid);

        } else if (choice==4) {
            System.out.println("LOGGING OUT");
            return;
        }
        else{
            System.out.println("INVALID CHOICE");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

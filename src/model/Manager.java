package model;

import Service.OrderService;
import java.util.Scanner;

public class Manager extends user {
    public Manager(int userid) {
        super(userid);
    }

    @Override
    public void showMenu() {
        OrderService orderService = new OrderService();
        Scanner sc = new Scanner(System.in);

        System.out.println("===== MANAGER MENU =====");
        System.out.println("1. View Total Sales");
        System.out.println("2. View Total Orders");
        System.out.println("3. View Date-wise Sales");
        System.out.println("4. Logout");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            orderService.showTotalSales();
        }
        else if (choice == 2) {
            orderService.showTotalOrdersCount();
        }
        else if (choice == 3) {
            orderService.showDateWiseSales();
        }
        else if (choice == 4) {
            System.out.println("Logged out");
        }
        else {
            System.out.println("Invalid choice");
        }
    }
}

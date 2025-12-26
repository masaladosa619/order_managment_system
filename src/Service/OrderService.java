package Service;

import dao.ProductDAO;
import dao.orderDAO;
import dao.orderitemDAO;
import model.Order;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    static orderDAO orderdao = new orderDAO();
    static orderitemDAO orderitemdao = new orderitemDAO();
    static ProductDAO productdao = new ProductDAO();

    public static void placeorder(int userid,int productid,int quantity) throws SQLException {
            Product product = productdao.getProductById(productid);
             if(product==null){
                 System.out.println("Product not found");
                 return;
             }

             if(quantity>product.getStock()){
                 System.out.println("NOT ENOUGH STOCK AVAILABLE");
                    return;
             }

             double totalamount = product.getPrice()*quantity;

             int orderid = orderdao.insetOrder(userid,totalamount);

             orderitemdao.InsertOrderitem(orderid,productid,quantity,product.getPrice());

             productdao.updateStock(productid,quantity);

            System.out.println("THE ORDER IS PLACED SUCCESSFULLY");
            System.out.println("YOUR ORDER ID IS:"+ orderid);

    }

    public void changeOrderStatus(int orderId, String status) {
        try {
            orderDAO.updateOrderStatus(orderId, status);
            System.out.println("✅ Order status updated successfully");
        } catch (SQLException e) {
            System.out.println("❌ Failed to update order status");
            e.printStackTrace();
        }
    }

    public void showTotalSales() {
        try {
            double sales = orderDAO.getTotalSales();
            System.out.println("Total Sales: ₹" + sales);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showTotalOrdersCount() {
        try {
            int count = orderDAO.getTotalOrdersCount();
            System.out.println("Total Orders: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showDateWiseSales() {
        try {
            orderDAO.getDateWiseSales();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void showAllOrders() {
        try {
            orderDAO orderdao = new orderDAO();
            List<Order> orders = orderdao.getallorders();
            for (Order o : orders) {
                System.out.println(o);
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch orders");
            e.printStackTrace();
        }
    }

}

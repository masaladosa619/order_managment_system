package dao;
import database.Dbconnection;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class orderDAO {
    public int insetOrder(int userid, double totalAmount) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "INSERT INTO orders (userid, order_status, order_date, total_amount) VALUES (?,'PLACED', CURRENT_DATE, ?)";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, userid);
        ps.setDouble(2, totalAmount);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return (rs.getInt(1));
        }
        return -1;
    }

    public void viewmyOrder(int userid) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "SELECT order_id, order_date, order_status, total_amount " +
                "FROM orders WHERE userid = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,userid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(
                    "OrderId:" +rs.getInt("order_id") +
                            "| DATE:"+ rs.getDate("order_date")+
                            "| STATUS:"+rs.getString("order_status")+
                            "| total_amount:"+rs.getDouble("total_amount")
            );

        }
    }
    public void ordercancel(int orderid) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "UPDATE orders SET order_status= 'CANCELLED' where order_id=? ";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,orderid);
        int rows = ps.executeUpdate();

        if(rows>0){
            System.out.println("YOUR ORDER IS SUCSSESFULLY CANCELLED");
        }
        else{
            System.out.println("INVALID ORDER ID");
        }
    }

    public List<Order> getallorders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection con = Dbconnection.getConnection();

        String sql = "SELECT order_id,userid,order_status,order_date,total_amount FROM orders";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            Order order = new Order(rs.getInt("order_id"),rs.getInt("userid"),rs.getDate("order_date").toLocalDate(),rs.getDouble("total_amount"),rs.getString("order_status"));
            orders.add(order);
        }
        return orders;
    }

    public static void updateOrderStatus(int orderId, String status) throws SQLException {

        Connection con = Dbconnection.getConnection();

        String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, status);
        ps.setInt(2, orderId);

        ps.executeUpdate();
    }

    public static double getTotalSales() throws SQLException {

        Connection con = Dbconnection.getConnection();
        String sql = "SELECT SUM(total_amount) AS total_sales FROM orders";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getDouble("total_sales");
        }
        return 0;
    }

    public static int getTotalOrdersCount() throws SQLException {

        Connection con = Dbconnection.getConnection();
        String sql = "SELECT COUNT(order_id) AS total_orders FROM orders";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("total_orders");
        }
        return 0;
    }

    public static void getDateWiseSales() throws SQLException {

        Connection con = Dbconnection.getConnection();
        String sql =
                "SELECT order_date, SUM(total_amount) AS total_sales " +
                        "FROM orders GROUP BY order_date";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getDate("order_date") +
                            " | Total Sales: ₹" +
                            rs.getDouble("total_sales")
            );
        }
    }






}
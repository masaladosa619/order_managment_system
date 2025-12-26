package dao;

import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderitemDAO {
    public void InsertOrderitem(int orderid, int productid, int quantity, double priceAtTime) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "INSERT INTO order_items(order_id,product_id,quantity,price_at_time) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,orderid);
        ps.setInt(2,productid);
        ps.setInt(3,quantity);
        ps.setDouble(4,priceAtTime);
        ps.executeUpdate();
    }

    public void viewOrderItems(int orderId) throws SQLException {
        Connection con = Dbconnection.getConnection();

        String sql =
                "SELECT p.product_name, oi.quantity, oi.price_at_time " +
                        "FROM order_items oi " +
                        "JOIN products p ON oi.product_id = p.product_id " +
                        "WHERE oi.order_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, orderId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    "Product: " + rs.getString("product_name") +
                            " | Qty: " + rs.getInt("quantity") +
                            " | Price: " + rs.getDouble("price_at_time")
            );
        }
    }
}

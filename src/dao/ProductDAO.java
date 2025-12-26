package dao;

import database.Dbconnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getAllproducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection con = Dbconnection.getConnection();
        String sql = "SELECT * from products";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Product p = new Product(rs.getInt("Product_id"),rs.getString("Product_name"),rs.getDouble("price"),rs.getInt("stock"));
            list.add(p);
        }
        return list;
    }
    public void updateStock(int productId, int quantity) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "UPDATE products SET stock = stock - ? WHERE product_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, quantity);
        ps.setInt(2, productId);
        ps.executeUpdate();
    }
    public Product getProductById(int productId) throws SQLException {
        Connection con = Dbconnection.getConnection();
        String sql = "SELECT * FROM products WHERE product_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
            );
        }
        return null;
    }
}

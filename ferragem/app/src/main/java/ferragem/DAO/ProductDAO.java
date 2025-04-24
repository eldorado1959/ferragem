package ferragem.dao;

import ferragem.dataBase.DBConnection;
import ferragem.database.DBConnection;
import ferragem.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void insert(Product product) {
        String sql = "INSERT INTO products (description, quantity, price) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getDescription());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.executeUpdate();

            System.out.println("Product inserted successfully.");

        } catch (SQLException e) {
            System.err.println("Error inserting product: " + e.getMessage());
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("id"),
                    rs.getString("description"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                );
                products.add(product);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching products: " + e.getMessage());
        }

        return products;
    }

    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Product product = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(
                    rs.getInt("id"),
                    rs.getString("description"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error finding product: " + e.getMessage());
        }

        return product;
    }

    public void update(Product product) {
        String sql = "UPDATE products SET description = ?, quantity = ?, price = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getDescription());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());

            stmt.executeUpdate();

            System.out.println("Product updated successfully.");

        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Product deleted successfully.");

        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
    }
}








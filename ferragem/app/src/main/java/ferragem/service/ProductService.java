package ferragem.service;

import ferragem.dao.ProductDAO;
import ferragem.model.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public void addProduct(String description, int quantity, double price) {
        Product product = new Product(description, quantity, price);
        productDAO.insert(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    public void updateProduct(int id, String description, int quantity, double price) {
        Product product = new Product(id, description, quantity, price);
        productDAO.update(product);
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }
}

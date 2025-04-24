package ferragem.controller;

import ferragem.model.Product;
import ferragem.service.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    public void createProduct(String description, int quantity, double price) {
        productService.addProduct(description, quantity, price);
    }

    public void listProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void updateProduct(int id, String description, int quantity, double price) {
        Product existing = productService.getProductById(id);
        if (existing != null) {
            productService.updateProduct(id, description, quantity, price);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        Product existing = productService.getProductById(id);
        if (existing != null) {
            productService.deleteProduct(id);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void showProduct(int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }
}

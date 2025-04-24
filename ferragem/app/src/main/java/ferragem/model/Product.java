package ferragem.model;

public class Product {
    private int id;
    private String description;
    private int quantity;
    private double price;

    // Constructors
    public Product() {}

    public Product(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(int id, String description, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", description=" + description +
               ", quantity=" + quantity + ", price=" + price + "]";
    }
}






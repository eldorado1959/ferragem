package ferragem.view;

import ferragem.controller.ProductController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductController controller = new ProductController();

        int option;
        do {
            System.out.println("\n=== Hardware Store Menu ===");
            System.out.println("1 - Add Product");
            System.out.println("2 - List Products");
            System.out.println("3 - Update Product");
            System.out.println("4 - Delete Product");
            System.out.println("5 - Show Product by ID");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {
                case 1 -> {
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    controller.createProduct(desc, qty, price);
                }
                case 2 -> controller.listProducts();
                case 3 -> {
                    System.out.print("Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    System.out.print("New Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("New Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("New Price: ");
                    double price = scanner.nextDouble();
                    controller.updateProduct(id, desc, qty, price);
                }
                case 4 -> {
                    System.out.print("Product ID to delete: ");
                    int id = scanner.nextInt();
                    controller.deleteProduct(id);
                }
                case 5 -> {
                    System.out.print("Product ID to show: ");
                    int id = scanner.nextInt();
                    controller.showProduct(id);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);

        scanner.close();
    }
}

package ferragem.view;

import ferragem.controller.ProductController;

import java.util.Scanner;

public class MainTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductController controller = new ProductController();

        int option;
        do {
            System.out.println("\n=== Hardware Store Menu ===");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Produto");
            System.out.println("3 - Alterar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("5 - Listar Produto p/ID");
            System.out.println("0 - Exit");
            System.out.print("Opcao: ");
            option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {
                case 1 -> {
                    System.out.print("Descricao: ");
                    String desc = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qty = scanner.nextInt();
                    System.out.print("Preco: ");
                    double price = scanner.nextDouble();
                    controller.createProduct(desc, qty, price);
                }
                case 2 -> controller.listProducts();
                case 3 -> {
                    System.out.print("Produto ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    System.out.print("Descricao: ");
                    String desc = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qty = scanner.nextInt();
                    System.out.print("New Price: ");
                    double price = scanner.nextDouble();
                    controller.updateProduct(id, desc, qty, price);
                }
                case 4 -> {
                    System.out.print("Informe ID para excluir: ");
                    int id = scanner.nextInt();
                    controller.deleteProduct(id);
                }
                case 5 -> {
                    System.out.print("Product ID to show: ");
                    int id = scanner.nextInt();
                    controller.showProduct(id);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao Incorreta.");
            }

        } while (option != 0);

        scanner.close();
    }
}

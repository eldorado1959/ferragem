package ferragem.view;

import ferragem.controller.ProductController;
import ferragem.dataBase.DBConnection;
import static ferragem.dataBase.DBConnection.getConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;



public class Main {
    public static void main(String[] args) {
        
        Connection conexao = DBConnection.getConnection();
        
// Cria janela principal
        JFrame frame = new JFrame("Loja de Ferragens");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1, 10, 10));

        ProductController controller = new ProductController();

        // Botão Adicionar Produto
        JButton addButton = new JButton("Adicionar Produto");
        addButton.addActionListener(e -> {
            String descricao = JOptionPane.showInputDialog("Descrição:");
            String quantidadeStr = JOptionPane.showInputDialog("Quantidade:");
            String precoStr = JOptionPane.showInputDialog("Preço:");
            try {
                int quantidade = Integer.parseInt(quantidadeStr);
                double preco = Double.parseDouble(precoStr);
                controller.createProduct(descricao, quantidade, preco);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
            }
        });

        // Botão Listar Produtos
        JButton listButton = new JButton("Listar Produtos");
        listButton.addActionListener(e -> controller.listProducts());

        // Botão Alterar Produto
        JButton updateButton = new JButton("Alterar Produto");
        updateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Produto:"));
                String desc = JOptionPane.showInputDialog("Nova Descrição:");
                int qty = Integer.parseInt(JOptionPane.showInputDialog("Nova Quantidade:"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Novo Preço:"));
                controller.updateProduct(id, desc, qty, price);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
            }
        });

        // Botão Deletar Produto
        JButton deleteButton = new JButton("Excluir Produto");
        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Produto a excluir:"));
                controller.deleteProduct(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
            }
        });

        // Botão Buscar por ID
        JButton searchButton = new JButton("Buscar Produto por ID");
        searchButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Produto:"));
                controller.showProduct(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
            }
        });

        // Botão Sair
        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(e -> System.exit(0));

        // Adiciona os botões à janela
        frame.add(addButton);
        frame.add(listButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(searchButton);
        frame.add(exitButton);

        frame.setVisible(true);
    }
}

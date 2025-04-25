package ferragem.dataBase;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable {
    public static void criarTabelas(Connection conexao) throws SQLException {
        String criarTabelaUsuarios = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255));";
        String criarTabelaProdutos = "CREATE TABLE IF NOT EXISTS products (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255));";
        
        Statement statement = conexao.createStatement();
        statement.execute(criarTabelaUsuarios);
        statement.execute(criarTabelaProdutos);
    }
}












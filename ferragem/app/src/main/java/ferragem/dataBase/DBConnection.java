package ferragem.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ferragem";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection()  {
        
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)){
        CreateTable.criarTabelas(conexao);
        return conexao;
        } catch (SQLException error){
            System.out.println("Erro: " + error.getMessage());
        }
        
        return null;
    }
}

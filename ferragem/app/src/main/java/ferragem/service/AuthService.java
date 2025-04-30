package ferragem.service;

import ferragem.dao.UserDAO;
import ferragem.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
    private final UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public boolean login(String email, String senhaDigitada) {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }

        // Verifica se a senha digitada corresponde ao hash armazenado
        boolean senhaValida = BCrypt.checkpw(senhaDigitada, user.getSenha());

        if (senhaValida) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + user.getNome());
            return true;
        } else {
            System.out.println("Senha incorreta.");
            return false;
        }
    }

    public void registrar(String nome, String email, String senha) {
        String hash = BCrypt.hashpw(senha, BCrypt.gensalt());
        User user = new User(nome, email, hash);
        userDAO.insert(user);
    }
}


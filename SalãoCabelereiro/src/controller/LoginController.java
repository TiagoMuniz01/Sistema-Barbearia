package controller;

import model.Profissional;

public class LoginController {

    // Método de autenticação, que verifica o email e CPF do profissional
    public boolean autenticar(String email, String cpf) {
        // Criar um objeto Profissional para buscar o profissional pelo email
        Profissional profissional = new Profissional();

        // Buscar o profissional pelo email
        profissional = profissional.buscarPorEmail(email);

        // Verificar se o profissional foi encontrado e se o CPF está correto
        if (profissional != null && profissional.getCpf().equals(cpf)) {
            return true;  // Login bem-sucedido
        }

        return false;  // Login falhou
    }
}


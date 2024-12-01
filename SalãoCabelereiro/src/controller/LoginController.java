package controller;

import controller.helper.LoginHelper;
import javax.swing.JOptionPane;
import model.Profissional;
import view.viewHome;
import view.viewLogin;

public class LoginController {

    private final viewLogin view;
    private final LoginHelper helper;

    public LoginController(viewLogin view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    // Método de autenticação, que verifica o email e CPF do profissional
    public void autenticar() {

        //Pegar um Profissional da view
        Profissional profissionalRequisitado = helper.obterModelo();

        //Pesquisa Profissional no Banco
        Profissional profissional = new Profissional();
        Profissional profissionalAutenticado = profissional.autenticar(profissionalRequisitado);

        if (profissionalAutenticado != null) {
            // Autenticação bem-sucedida, navegar para home
            viewHome home = new viewHome();

            JOptionPane.showMessageDialog(home, "Bem vindo de volta " + profissionalAutenticado.getNome(), "Login realizado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            home.setVisible(true);
            view.setVisible(false);
 
        } else {
            // Falha na autenticação
            JOptionPane.showMessageDialog(null, "Credenciais inválidas.", "Erro", JOptionPane.ERROR_MESSAGE);
            helper.limparTela();
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

import model.Profissional;
import view.viewLogin;

/**
 *
 * @author Tiago e Diogo
 */
public class LoginHelper implements IHelper{
    
    private final viewLogin view;

    public LoginHelper(viewLogin view) {
        this.view = view;
    }
    
    public Profissional obterModelo(){
        String email = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        Profissional modelo = new Profissional(0, email, senha);
        return modelo;
    }
    
    public void setarModelo(Profissional modelo){
        String email = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        
        view.getTextUsuario().setText(email);
        view.getTextSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }
    
}

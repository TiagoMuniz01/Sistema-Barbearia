/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.cadastro.viewAgendamento;
import view.viewHome;


/**
 *
 * @author Tiago e Diogo
 */
public class HomeController {
    
    private final viewHome view;

    public HomeController(viewHome view) {
        this.view = view;
    }
    
    public void navegarParaAgenda(){
        
        viewAgendamento agendamento = new viewAgendamento();
        agendamento.setVisible(true);
    }
    
    
}

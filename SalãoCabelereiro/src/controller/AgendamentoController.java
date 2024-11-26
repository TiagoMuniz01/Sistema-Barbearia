package controller;


import controller.helper.AgendamentoHelper;
import java.util.ArrayList;
import model.Agendamento;
import view.cadastro.viewAgendamento;

public class AgendamentoController{

    private final viewAgendamento view;
    private final AgendamentoHelper helper;


    public AgendamentoController(viewAgendamento view) {
        this.view = view;
        this.helper = new AgendamentoHelper(view);
    }
    
    
    public void atualizar(){
        
        //Buscar lista com agendaemntos no banco de dados
        Agendamento agendamento = new Agendamento();
        ArrayList<Agendamento> agendamentos = Agendamento.listar();
        
        //Exibir esta lista na view
        helper.prencerTabela(agendamentos);
        
    }     
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Agendamento {

    private int cod_agendamento;
    private Cliente cliente; // FK (Essa variável permite guardar um objeto do tipo Cliente)
    private Profissional profissional; // FK
    private Pagamento pagamento; // FK
    private int cod_servico;
    private LocalTime horario_agendamento;
    private LocalDate data_agendamento;

    // Construtor com tratamento para a data e horário de agendamento
    public Agendamento(int cod_agendamento, Cliente cliente, Profissional profissional, Pagamento pagamento, int cod_servico, String horario_agendamento, String data_agendamento) {
        this.cod_agendamento = cod_agendamento;
        this.cliente = cliente;
        this.profissional = profissional;
        this.pagamento = pagamento;
        this.cod_servico = cod_servico;

        // Tenta converter a string horario_agendamento para LocalTime
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.horario_agendamento = LocalTime.parse(horario_agendamento, timeFormatter);
            System.out.println("Horário de agendamento convertido com sucesso: " + this.horario_agendamento);
        } catch (DateTimeParseException ex) {
            System.out.println("Erro: Horário de agendamento no formato inválido. Use o formato HH:mm.");
        }

        // Tenta converter a string data_agendamento para LocalDate
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.data_agendamento = LocalDate.parse(data_agendamento, dateFormatter);
            System.out.println("Data de agendamento convertida com sucesso: " + this.data_agendamento);
        } catch (DateTimeParseException ex) {
            System.out.println("Erro: Data de agendamento no formato inválido. Use o formato dd/MM/yyyy.");
        }
    }

    public int getCod_agendamento() {
        return cod_agendamento;
    }

    public void setCod_agendamento(int cod_agendamento) {
        this.cod_agendamento = cod_agendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public int getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(int cod_servico) {
        this.cod_servico = cod_servico;
    }

    public LocalTime getHorario_agendamento() {
        return horario_agendamento;
    }

    public void setHorario_agendamento(String horario_agendamento) {
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.horario_agendamento = LocalTime.parse(horario_agendamento, timeFormatter);
            System.out.println("Horário de agendamento atualizado com sucesso: " + this.horario_agendamento);
        } catch (DateTimeParseException ex) {
            System.out.println("Erro: Horário de agendamento no formato inválido. Use o formato HH:mm.");
        }
    }

    public LocalDate getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.data_agendamento = LocalDate.parse(data_agendamento, dateFormatter);
            System.out.println("Data de agendamento atualizada com sucesso: " + this.data_agendamento);
        } catch (DateTimeParseException ex) {
            System.out.println("Erro: Data de agendamento no formato inválido. Use o formato dd/MM/yyyy.");
        }
    }
}

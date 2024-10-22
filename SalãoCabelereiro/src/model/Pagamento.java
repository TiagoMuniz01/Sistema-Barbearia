/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tiago e Diogo
 */
public class Pagamento {
    private int cod_pagamento;
    private String tipo_pagamento;

    public Pagamento(int cod_pagamento, String tipo_pagamento) {
        this.cod_pagamento = cod_pagamento;
        this.tipo_pagamento = tipo_pagamento;
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }
    
    
}

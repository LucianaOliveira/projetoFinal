/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luciana_2
 */
public class Comissao {
    
    private String comissao;
    private Venda venda;
    
    
    public Comissao(String comissao, Venda venda){
        
        this.comissao = comissao;
        this.venda = venda;
    }

    public Comissao() {
    }
    
    
    
}

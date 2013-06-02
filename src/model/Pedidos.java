/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luciana_2
 */
public class Pedidos {
    private Integer quantidade;
    private String status;
    private Double valortotal;
    
    public Pedidos(Integer quantidade, String status, Double valortotal){
        
        this.quantidade = quantidade;
        this.status = status;
        this.valortotal = valortotal;
        
    }

    public Pedidos() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }
    
    
}

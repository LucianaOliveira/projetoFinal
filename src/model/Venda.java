/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Luciana_2
 */
public class Venda {
    
    private Integer numero_venda;
    private Date datapedido;
    private Integer quantidade;
    private Double valor;
    private Vendedor vendedor;
    
    
    
    public Venda (Integer numero_venda, Date datapedido, Integer quantidade, Double valor, Vendedor vendedor){
        
        this.numero_venda = numero_venda;
        this.datapedido = datapedido;
        this.quantidade = quantidade;
        this.valor = valor;
        this.vendedor = vendedor;
       
    }

    public Venda() {
    }

    public Integer getNumero_venda() {
        return numero_venda;
    }

    public void setNumero_venda(Integer numero_venda) {
        this.numero_venda = numero_venda;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

   
    
}

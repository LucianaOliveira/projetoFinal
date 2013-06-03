
package model;

/**
 *
 * @author Luciana_2
 */
public class Vendedor {
    
    private String nome;
    private Double comissao;
    
    public Vendedor(String nome, Double comissao){
        
        this.nome = nome;
        this.comissao = comissao;
    }

    public Vendedor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
    
    
    
}

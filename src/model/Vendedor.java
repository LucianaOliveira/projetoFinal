
package model;

/**
 *
 * @author Luciana_2
 */
public class Vendedor {
    private Integer cod_vendedor;
    private String nome;
    private Double comissao;
    
    public Vendedor(Integer cod_vendedor, String nome, Double comissao){
        this.cod_vendedor = cod_vendedor;
        this.nome = nome;
        this.comissao = comissao;
    }

    public Vendedor() {
    }

    public Integer getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(Integer cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
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

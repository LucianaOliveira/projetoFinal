
package model;

/**
 *
 * @author Luciana_2
 */
public class Produtos {
    
    private String nome;
    private String descrição;
    private EstoqueProduto estoque;
    private Double preço;
    private boolean status;
    
    public Produtos(String nome, String descrição, EstoqueProduto estoque,
            Double preço,boolean status){
        
        this.nome = nome;
        this.descrição = descrição;
        this.estoque = estoque;
        this.preço = preço;
        this.status = status;
        
    }

    public Produtos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public EstoqueProduto getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueProduto estoque) {
        this.estoque = estoque;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}


package model;

/**
 *
 * @author Luciana_2
 */
public class Produtos {
    
    private Integer codigo;
    private String nome;
    private String descrição;
    private EstoqueProduto estoque;
    private Double preço;
    //private String status;
    private String tipo;
    private Fornecedores fornecedor;
    
    public Produtos(Integer codigo, String nome, String descrição, EstoqueProduto estoque,
            Double preço,String tipo, Fornecedores fornecedor){
        this.codigo = codigo;
        this.nome = nome;
        this.descrição = descrição;
        this.estoque = estoque;
        this.preço = preço;

        this.tipo = tipo;
        this.fornecedor = fornecedor;
        
        
    }

    public Produtos() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }

  
    
    
}

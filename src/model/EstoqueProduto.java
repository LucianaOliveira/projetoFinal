
package model;

/**
 *
 * @author Luciana_2
 */
public class EstoqueProduto {
    
    private Integer codestoque;
    private Integer quantidade;
    
    public EstoqueProduto(Integer codestoque, Integer quantidade){
        this.codestoque = codestoque;
        this.quantidade = quantidade;
    }

    public EstoqueProduto() {
    }

    public Integer getCodestoque() {
        return codestoque;
    }

    public void setCodestoque(Integer cod_estoque) {
        this.codestoque = codestoque;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
}

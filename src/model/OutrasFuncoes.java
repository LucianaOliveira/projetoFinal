
package model;

/**
 *
 * @author Luciana_2
 */
public class OutrasFuncoes {
    
    private Integer cod_funcoes;
    private String nome;
    private Double salario;
    
    public OutrasFuncoes(Integer cod_funcoes, String nome, Double salario){
        this.cod_funcoes = cod_funcoes;
        this.nome = nome;
        this.salario = salario;
    }

    public OutrasFuncoes() {
    }

    public Integer getCod_funcoes() {
        return cod_funcoes;
    }

    public void setCod_funcoes(Integer cod_funcoes) {
        this.cod_funcoes = cod_funcoes;
    }


  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    
    
}


package model;

/**
 *
 * @author Luciana_2
 */
public class OutrasFuncoes {
    
    private Integer cod;
    private String nome;
    private Double salario;
    
    public OutrasFuncoes(Integer cod, String nome, Double salario){
        this.cod = cod;
        this.nome = nome;
        this.salario = salario;
    }

    public OutrasFuncoes() {
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
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

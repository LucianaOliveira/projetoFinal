
package model;

import java.util.Date;

/**
 *
 * @author Luciana_2
 */
public class Vendedor {
    private Integer cod_vendedor;
    private String nome;
    private String cpf;
    private String rg;
    private Endereco endereco;
    private String telefone;
    private Date datanascimento;
    private Date dataadmissao;
    private Comissao comissao;
    
    
    public Vendedor(Integer cod_vendedor, String nome, String cpf, String rg, 
             Endereco endereco,String telefone, Date datanascimento, Date dataadmissao, Comissao comissao){
        this.cod_vendedor = cod_vendedor;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.datanascimento = datanascimento;
        this.dataadmissao = dataadmissao;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

  

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

 

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Date getDataadmissao() {
        return dataadmissao;
    }

    public void setDataadmissao(Date dataadmissao) {
        this.dataadmissao = dataadmissao;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }

    
    
    
}

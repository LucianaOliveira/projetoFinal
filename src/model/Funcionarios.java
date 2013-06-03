/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Funcionarios {
    
    private String nome;
    private String cpf;
    private String rg;
    private Cargo cargo;
    private Endereco endereco;
    private String telefone;
    private String status;
    
    
    
    public Funcionarios(String nome, String cpf, String rg, Cargo cargo, 
             Endereco endereco,String telefone, String status){
        
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.cargo = cargo;
        this.telefone = telefone;
        this.status = status;
        this.endereco = endereco;
       
        
        
        
    }

    public Funcionarios() {
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   


    
    
}

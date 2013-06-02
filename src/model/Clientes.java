
package model;

/**
 *
 * @author Luciana_2
 */
public class Clientes {
    
    private String razaosocial;
    private String nomefantasia;
    private String dados;
    private Endereco endereco;
    private String telefone;
    private String status;
    
   
    
           
    public Clientes(String razaosocial, String nomefantasia,String dados,
            Endereco endereco, String telefone, String status){
        
        this.razaosocial = razaosocial;
        this.nomefantasia = nomefantasia;
        this.dados = dados;
        this.telefone = telefone;
        this.status = status;
        this.endereco = endereco;
        
    }

    public Clientes() {
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
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

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
            
    
}

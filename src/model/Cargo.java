
package model;

/**
 *
 * @author Luciana_2
 */
public class Cargo {
    
    private String nomecargo;
    private Vendedor vendedor;
    private OutrasFuncoes outrasfuncoes;
    
    public Cargo (String nomecargo, Vendedor vendedor, OutrasFuncoes outrasfuncoes){
        
        this.nomecargo = nomecargo;
        this.vendedor = vendedor;
        this.outrasfuncoes = outrasfuncoes;
    }

    public Cargo() {
    }

    public String getNomecargo() {
        return nomecargo;
    }

    public void setNomecargo(String nomecargo) {
        this.nomecargo = nomecargo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public OutrasFuncoes getOutrasfuncoes() {
        return outrasfuncoes;
    }

    public void setOutrasfuncoes(OutrasFuncoes outrasfuncoes) {
        this.outrasfuncoes = outrasfuncoes;
    }

    
    
}

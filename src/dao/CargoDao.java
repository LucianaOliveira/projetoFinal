
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cargo;
import model.OutrasFuncoes;
import model.Vendedor;


public class CargoDao {
    
    private Connection con = ConectaBanco.getConexao();
    private VendedorDao vendedorDao = new VendedorDao();
    private OutrasFuncoesDao outrasfuncoesDao = new OutrasFuncoesDao();
    
    public String addCargo(Cargo cargo){
        Integer cod_vendedor = vendedorDao.addVendedor(cargo.getVendedor());
        Integer cod_funcoes = outrasfuncoesDao.addOutrasFuncoes(cargo.getOutrasfuncoes());
        
        PreparedStatement ps = null;
        
        String sql = "insert into cargo(nomecargo, vendedor, outrasfuncoes) values(?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getNomecargo());
            ps.setInt(2, cod_vendedor);
            ps.setInt(3, cod_funcoes);
            ps.execute();
            return getLastCargo();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return null;
        }
    
       
        
    

    
    
     private String getLastCargo() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select nomecargo from cargo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getString(2);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }return null;
        }
        
}
    
    



package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;


public class CargoDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    public void addCargo(Cargo cargo){
        PreparedStatement ps = null;
        
        String sql = "insert into cargo(nomecargo) values(?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getNomecargo());
            ps.execute();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        
    }

 /**   static String nomecargo() {
        String sql = "select nomecargo from cargo";
        ResultSet rs = null;
        
        try{
            PreparedStatement psConsulta = con.prepareStatement(sql);
            rs = psConsulta.executeQuery();
            String nome;
            
            rs.next();
            
            nome = rs.getString("nomecargo");
            return nome;
            
        }catch(SQLException ex){
            System.out.println("Erro ao tentar pegar nomecargo!");
            
        }return null;
    } */
    
    public ArrayList<Cargo> getCargos(){
        ArrayList<Cargo> cargos = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String sql = "select * from cargo";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cargos.add(getCargoFromSql(rs));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }return cargos;
    }
    
    
    

    private Cargo getCargoFromSql(ResultSet rs) {
        
        String nomecargo = null;
        
        try{
            nomecargo = rs.getString(2);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return new Cargo(nomecargo);
        
    }
    
    public void updateCargoByNomecargo(Cargo cargo){
        
        PreparedStatement ps = null;
        String sql = "update cargo set nomecargo=? where nomecargo=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getNomecargo());
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }

    String nomecargo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

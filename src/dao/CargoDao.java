
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;
import model.OutrasFuncoes;
import model.Vendedor;


public class CargoDao {
    
    private Connection con = ConectaBanco.getConexao();
    VendedorDao vendedorDao = new VendedorDao();
    OutrasFuncoesDao outrasfuncoesDao = new OutrasFuncoesDao();
    
    public void addCargo(Cargo cargo){
        PreparedStatement ps = null;
        
        String sql = "insert into cargo(nomecargo, vendedor, outrasfuncoes) values(?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getNomecargo());
            ps.setInt(2,vendedorDao.codVendedor() );
            ps.setInt(3, outrasfuncoesDao.CodOF());
            ps.execute();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        
    }

    public String nomecargo() {
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
    } 
    
    public ArrayList<Cargo> getCargos(){
        ArrayList<Cargo> cargos = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String sql = "select * from cargo";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cargos.add(getCargosFromSql(rs));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }return cargos;
    }
    
    
    

    private Cargo getCargoFromSql(ResultSet rs, int codVendedor, int codOF) {
        
        String nomecargo = null;
        Vendedor vendedor = null;
        OutrasFuncoes outrasfuncoes = null;
        
        try{
            nomecargo = rs.getString(2);
            codVendedor = rs.getInt(3);
            codOF = rs.getInt(4);
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return new Cargo(nomecargo, vendedor, outrasfuncoes);
        
    }
    
    public void updateCargoByNomecargo(Cargo cargo){
        
        PreparedStatement ps = null;
        String sql = "update cargo set vendedor=?,outrasfuncoes=? where nomecargo=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, vendedorDao.codVendedor());
            ps.setInt(2, outrasfuncoesDao.CodOF());
            ps.setString(3, cargo.getNomecargo());
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }

    private Cargo getCargosFromSql(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Vendedor;

/**
 *
 * @author Luciana_2
 */
public class VendedorDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    public void addVendedor(Vendedor vendedor){
        
        PreparedStatement ps = null;
        String sql = "insert into vendedor (cod_vendedor, nome,comissao)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, vendedor.getCod_vendedor());
            ps.setString(2, vendedor.getNome());
            ps.setDouble(3, vendedor.getComissao());
            ps.execute();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
    }
    
    public ArrayList<Vendedor> getVendedores(){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String sql = "select * from vendedor";
        
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            while(rs.next()){
                vendedores.add(getVendedoresFromSql(rs));
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }return vendedores;
        
    }
    
    private Vendedor getVendedoresFromSql(ResultSet rs){
        Integer cod_vendedor = null;
        String nome = null;
        Double comissao = null;
        
        try{
            nome = rs.getString(2);
            comissao = rs.getDouble(3);
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return new Vendedor(cod_vendedor, nome, comissao);

   
    }
    
    public void updateVendedorByCod_vendedor(Vendedor vendedor){
        
        PreparedStatement ps = null;
        String sql = " update vendedor set nome=?, comissao=? where cod_vendedor=?";
        
       try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, vendedor.getCod_vendedor());
           ps.setString(2, vendedor.getNome());
           ps.setDouble(3, vendedor.getComissao());
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
    }
        
        
    



package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Clientes;
import model.Endereco;

/**
 *
 * @author Luciana_2
 */
public class ClientesDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    EnderecoDao enderecoDao = new EnderecoDao();
    
    public void addClientes(Clientes clientes){
        PreparedStatement ps = null;
        
        String sql = "insert into clientes (razaosocial, nomefantasia,dados,id_endereco, telefone,status) values (?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getRazaosocial()); 
            ps.setString(2, clientes.getNomefantasia()); 
            ps.setString(3, clientes.getDados());
            ps.setInt(4, enderecoDao.pegarID());
            ps.setString(5, clientes.getTelefone());
            ps.setString(6, clientes.getStatus());
            ps.execute();
       }catch(SQLException ex){
           ex.printStackTrace();
           
       }
        
    }
    
    public ArrayList<Clientes> getCliente(int id_endereco){
        ArrayList<Clientes> cliente = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "select * from clientes";
         try{
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             while(rs.next()){
                 cliente.add(getClienteFromSql(rs, id_endereco));
                 
             }
             
         }catch(SQLException ex){
             ex.printStackTrace();
             
             
         }return cliente;
        
        
    }

    private Clientes getClienteFromSql(ResultSet rs, int pegarID) {
        
        String razaosocial = null;
        String nomefantasia = null;
        String dados = null;
        Endereco endereco = null;
        String telefone = null;
        String status = null;
        
        try{
            razaosocial = rs.getString(2);
            nomefantasia = rs.getString(3);
            dados = rs.getString(4);
            pegarID = rs.getInt(5); 
            telefone = rs.getString(6);
            status = rs.getString(7);
            
       
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        
        return new Clientes(razaosocial, nomefantasia, dados, endereco, telefone, status);
        
    }
    
    public void updateClientesByDados(Clientes clientes){
        PreparedStatement ps = null;
        String sql = "update clientes set razaosocial=?, nomefantasia=?, endereco=?, telefone=?, status=?  where dados =?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getRazaosocial());
            ps.setString(2, clientes.getNomefantasia());
            ps.setString(3, clientes.getDados());
            ps.setInt(4, enderecoDao.pegarID());
            ps.setString(5, clientes.getTelefone());
            ps.setString(6, clientes.getStatus());
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    

    
    
    
    
    
}


package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Clientes;
import model.Endereco;

/**
 *
 * @author Luciana_2
 */
public class ClientesDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    private EnderecoDao enderecoDao = new EnderecoDao();
    
    public void addClientes(Clientes clientes){
        Integer id_endereco = enderecoDao.addEndereco(clientes.getEndereco());
        PreparedStatement ps = null;
        
        String sql = "insert into clientes (razaosocial, nomefantasia,dados,id_endereco, telefone,status,datacadastro) values (?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getRazaosocial()); 
            ps.setString(2, clientes.getNomefantasia()); 
            ps.setString(3, clientes.getDados());
            ps.setInt(4, id_endereco);
            ps.setString(5, clientes.getTelefone());
            ps.setString(6, clientes.getStatus());
            ps.setDate(7, new Date(clientes.getDatacadastro().getTime()));
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
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
                 cliente.add(getClienteFromSql(rs));
                 
             }
             
         }catch(SQLException ex){
             ex.printStackTrace();
             
             
         }return cliente;
        
        
    }

    private Clientes getClienteFromSql(ResultSet rs) {
        
        String razaosocial = null;
        String nomefantasia = null;
        String dados = null;
        String telefone = null;
        String status = null;
        Date datacadastro = null;
        String rua = null;
        String numero = null;
        String cep = null;
        String complemento = null;
        String bairro = null;
        String cidade = null;
        String estado = null;
        
        
        try{
            razaosocial = rs.getString(2);
            nomefantasia = rs.getString(3);
            dados = rs.getString(4);           
            telefone = rs.getString(5);
            status = rs.getString(6);
            datacadastro = rs.getDate(7);
            rua = rs.getString(8);
            numero = rs.getString(9);
            cep = rs.getString(10);
            complemento =  rs.getString(11);
            bairro = rs.getString(12);
            cidade = rs.getString(13);
            estado = rs.getString(14);
            
       
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        Endereco endereco = new Endereco(rua, numero, cep, complemento, bairro, cidade, estado);
        return new Clientes(razaosocial, nomefantasia, dados, endereco, telefone, status, datacadastro);
        
    }
    
    public void updateClientesByDados(Clientes clientes){
        PreparedStatement ps = null;
        String sql = "update clientes set razaosocial=?  where dados =?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getRazaosocial());
            ps.setString(2, clientes.getDados());
            ps.executeUpdate();
           
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    

    
    
    
    
    
}

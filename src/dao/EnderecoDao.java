
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;

/**
 *
 * @author Luciana_2
 */
public class EnderecoDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    
    public void addEndereco(Endereco endereco){
        PreparedStatement ps = null;
        
        String sql = "insert into Endereco(rua,numero,cep,complemento,bairro,cidade ) values (?,?,?,?,?,?)";
        
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getNumero());
            ps.setString(4, endereco.getCep());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.execute();
            
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public int pegarID(){
        
        String sql = "select id_endereco from endereco order by id_endereco";
        ResultSet rs = null;
        try {
            PreparedStatement psConsulta = con.prepareStatement(sql);
            rs = psConsulta.executeQuery();
            int id;
            rs.next();
            
             id =   rs.getInt("id_endereco");
            
              return id;
       
        } catch (SQLException ex) {
            
            System.out.println("Erro ao pegar IdEndereco!");
        
        }
        
        return 0;
      
    }
    
    
    public ArrayList<Endereco> getEnderecos(){
        ArrayList<Endereco> enderecos = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "select * from endereco";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                enderecos.add(getEnderecosFromSql(rs));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }return enderecos;
    }
    
    private Endereco getEnderecoFromSql(ResultSet rs, int endereco){
        
        String rua = null;
        String numero = null;
        String cep = null;
        String complemento = null;
        String bairro = null;
        String cidade = null;
        
        try{
            rua = rs.getString(2);
            numero = rs.getString(3);
            cep = rs.getString(4);
            complemento = rs.getString(5);
            bairro = rs.getString(6);
            cidade = rs.getString(7);
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return new Endereco(rua, numero, cep, complemento, bairro, cidade, endereco);
        
        
    }
    
    public void updateEnderecoByCep(Endereco endereco){
        
        PreparedStatement ps = null;
        String sql = "update endereco set rua=?, numero=?, complemento=?, bairro=?, cidade=? where cep=?";
        
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getNumero());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getCep());
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
    

    private Endereco getEnderecosFromSql(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

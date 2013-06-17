
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
    
    
    public Integer addEndereco(Endereco endereco) throws SQLException,ClassNotFoundException{
        PreparedStatement ps = null;
        
        String sql = "insert into Endereco(rua,numero,cep,complemento,bairro,cidade,estado ) values (?,?,?,?,?,?,?)";
        
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getNumero());
            ps.setString(4, endereco.getCep());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getCidade());
            ps.setString(8, endereco.getEstado());
            ps.execute();
            return getLastEndereco();       
                     
        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
    }
    }
    private Integer getLastEndereco() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select max(id) from endereco";
        try {
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
            
        }return null;
            
        }
        
        
      
}

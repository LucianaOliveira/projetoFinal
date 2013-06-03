
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Endereco;
import model.Fornecedores;


/**
 *
 * @author Luciana_2
 */
public class FornecedoresDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    EnderecoDao enderecoDao = new EnderecoDao();
    
    
    public void addFornecedores(Fornecedores fornecedores){
        PreparedStatement ps = null;
        
        String sql = "insert into fornecedores (razaosocial, nomefantasia, cnpj,endereco,telefone, email) values(?,?,?,?,?,?)";
        
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,fornecedores.getRazaosocial() );
            ps.setString(2, fornecedores.getNomefantasia());
            ps.setString(3, fornecedores.getCnpj());
            ps.setInt(4, enderecoDao.pegarID());
            ps.setString(5, fornecedores.getTelefone());
            ps.setString(6, fornecedores.getEmail());
            ps.execute();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
            
        }
        
        
        
        
    }
    public ArrayList<Fornecedores> getFornecedor(){
        
        ArrayList<Fornecedores> fornecedor = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "select * from fornecedores";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                fornecedor.add(getFornecedorFromSql(rs));
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    return fornecedor;
    
}
    
    private Fornecedores getFornecedorFromSQL(ResultSet rs, int pegarID){
        
        String razaosocial = null;
        String nomefantasia = null;
        String cnpj = null;
        Endereco endereco = null;
        String telefone = null;
        String email = null;
        
        try{
            razaosocial = rs.getString(2);
            nomefantasia = rs.getString(3);
            cnpj = rs.getString(4);
            pegarID = rs.getInt(5);
            telefone = rs.getString(6);
            email = rs.getString(7);
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return new Fornecedores(razaosocial, nomefantasia, cnpj, endereco, telefone, email);
    }
    
    
    public void updateFornecedoresByCnpj(Fornecedores fornecedores){
        
        PreparedStatement ps = null;
        String sql = "update fornecedores set razaosocial=?, nomefantasia=?, endereco=?, telefone=?, email=? where cnpj=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, fornecedores.getRazaosocial());
            ps.setString(2, fornecedores.getNomefantasia());
            ps.setString(3, fornecedores.getCnpj());
            ps.setInt(4, enderecoDao.pegarID());
            ps.setString(5, fornecedores.getTelefone());
            ps.setString(6, fornecedores.getEmail());
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    

    private Fornecedores getFornecedorFromSql(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

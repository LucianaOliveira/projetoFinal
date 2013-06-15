/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.EstoqueProduto;

/**
 *
 * @author Luciana_2
 */
public class EstoqueprodutoDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    public void addEstoqueProduto(EstoqueProduto estoqueproduto){
        
        PreparedStatement ps = null;
        String sql = "insert into estoqueproduto(codestoque, quantidade) values (?,?)";
        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, estoqueproduto.getCodestoque());
            ps.setInt(2, estoqueproduto.getQuantidade());
            ps.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    public int codEstoque(){
             
         
        String sql = "select codestoque from estoqueproduto order by codestoque";
        ResultSet rs = null;
        
        try {
            PreparedStatement psConsulta = con.prepareStatement(sql);
            rs = psConsulta.executeQuery();
            int codestoque;
            rs.next();
            codestoque = rs.getInt("codestoque");
            return codestoque;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar codigo do estoque");
        }return 0;
        
    }
    public ArrayList <EstoqueProduto> getEstoqueprodutos(){
        
        ArrayList<EstoqueProduto> estoqueprodutos = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String sql = "select * from estoqueproduto";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                estoqueprodutos.add(getEstoqueprodutosFromSql(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }return estoqueprodutos;
        
    }

    private EstoqueProduto getEstoqueprodutosFromSql(ResultSet rs, int codestoque) {
        
        Integer quantidade = null;
        
       
        try{
            
            quantidade = rs.getInt(2);
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return new EstoqueProduto(codestoque, quantidade);
        
    }
    public void updateEstoqueprodutoByCod(EstoqueProduto estoqueproduto){
        
        PreparedStatement ps = null;
        String sql = "update estoqueproduto set quantidade=? where codestoque=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estoqueproduto.getCodestoque());
            ps.setInt(2, estoqueproduto.getQuantidade());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private EstoqueProduto getEstoqueprodutosFromSql(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
    
}

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
import javax.swing.JOptionPane;
import model.EstoqueProduto;
import model.Fornecedores;

import model.Produtos;

/**
 *
 * @author Luciana_2
 */
public class produtosDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    EstoqueprodutoDao estoqueprodutoDao = new EstoqueprodutoDao();
    FornecedoresDao fornecedoresDao = new FornecedoresDao();
    
    
    public void addProdutos(Produtos produtos) throws SQLException, ClassNotFoundException{
        Integer codestoque =  estoqueprodutoDao.addEstoqueProduto(produtos.getEstoque());
          
        String cnpj = fornecedoresDao.addFornecedores(produtos.getFornecedor());
        
        PreparedStatement ps = null;
        
        String sql = "insert into produtos(codigo, nome, descrição,cod_estoque, preço,status, tipo, cnpj) values(?,?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, produtos.getCodigo());
            ps.setString(2, produtos.getNome());
            ps.setString(3, produtos.getDescrição());
            ps.setInt(4, codestoque);
            ps.setDouble(5, produtos.getPreço());
            ps.setString(6, produtos.getTipo());
            ps.setString(7, cnpj);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }       
        
    }
    
    public ArrayList<Produtos> getProduto(){
        ArrayList<Produtos> produto = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String sql = "select * from produtos";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                produto.add(getProdutoFromSql(rs));
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }return produto;
    
}
    
    private Produtos getProdutoFromSql(ResultSet rs){
        
        Integer codigo = null;
        String nome = null;
        String descricao = null;        
        Double preco = null;
        String status = null;
        String tipo = null;
        Integer codestoque = null;
        Integer quantidade = null;
        String razaosocial = null;
        String nomefantasia = null;
        String cnpj = null;
        String telefone = null;
        String email = null;
        
        try{
            codigo = rs.getInt(2);
            nome = rs.getString(3);
            descricao = rs.getString(4);
            preco = rs.getDouble(5);
            status = rs.getString(6);
            tipo = rs.getString(7);
            codestoque = rs.getInt(8);
            quantidade = rs.getInt(9);
            razaosocial = rs.getString(10);
            nomefantasia = rs.getString(11);
            cnpj = rs.getString(12);
            telefone = rs.getString(13);
            email = rs.getString(14);
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        Fornecedores fornecedores = new Fornecedores(razaosocial, nomefantasia, cnpj, null, telefone, email);
        return new Produtos(codigo, nome, descricao, null, preco, tipo, fornecedores);
       
        
    }
    
    public void updateProdutosByCodigo(Produtos produtos){
        PreparedStatement ps = null;
        String sql = "update produtos set nome=? where codigo=?";
        
        try{
            ps = con.prepareStatement(sql);         
            ps.setString(2, produtos.getNome());
            ps.setInt(3, produtos.getCodigo());
            
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }

    
    
    
    

    
    
}

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
    
    
    public void addProdutos(Produtos produtos){
        Integer codestoque = = estoqueprodutoDao.addEstoqueProduto(produtos.getEstoque());
        String cnpj = fornecedoresDao.addFornecedores(produtos.getFornecedor());
        
        PreparedStatement ps = null;
        
        String sql = "insert into produtos(codigo, nome, descrição,cod_estoque, preço,status, tipo, cnpj) values(?,?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, produtos.getCodigo());
            ps.setString(2, produtos.getNome());
            ps.setString(3, produtos.getDescrição());
            ps.setInt(4, estoqueprodutoDao.codEstoque());
            ps.setDouble(5, produtos.getPreço());
            ps.setString(6, produtos.getStatus());
            ps.setString(7, produtos.getTipo());
            ps.setString(8, cnpj);
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
    
    private Produtos getProdutoFromSql(ResultSet rs,int CodEstoque){
        
        Integer codigo = null;
        String nome = null;
        String descricao = null;
        EstoqueProduto estoque = null;
        Double preco = null;
        String status = null;
        String tipo = null;
        
        try{
            codigo = rs.getInt(2);
            nome = rs.getString(3);
            descricao = rs.getString(4);
            CodEstoque = rs.getInt(5);
            preco = rs.getDouble(6);
            status = rs.getString(7);
            tipo = rs.getString(8);
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        Fornecedores fornecedores = new Fornecedores(descricao, nome, tipo, null, tipo, tipo)
        return new Produtos(codigo, nome, descricao, estoque, preco, status, tipo, null)
       
        
    }
    
    public void updateProdutosByCodigo(Produtos produtos){
        PreparedStatement ps = null;
        String sql = "update produtos set nome=?, descricao=?, estoque=?, preco=?, status=?, tipo=? where codigo=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, produtos.getCodigo());
            ps.setString(2, produtos.getNome());
            ps.setString(3, produtos.getDescrição());
            ps.setInt(4, estoqueprodutoDao.codEstoque());
            ps.setDouble(5, produtos.getPreço());
            ps.setString(6, produtos.getStatus());
            ps.setString(7, produtos.getTipo());
            
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }

    private Produtos getProdutoFromSql(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
    
}

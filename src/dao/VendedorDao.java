
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Endereco;
import model.Vendedor;

/**
 *
 * @author Luciana_2
 */
public class VendedorDao {
    
    private Connection con = ConectaBanco.getConexao();
    private EnderecoDao enderecoDao = new EnderecoDao();
 
    
    public Integer addVendedor(Vendedor vendedor) throws SQLException, ClassNotFoundException{
        
        Integer id_endereco = enderecoDao.addEndereco(vendedor.getEndereco());

        
        
        PreparedStatement ps = null;
        String sql = "insert into vendedor (cod_vendedor, nome,cpf,rg,telefone,id_endereco,datanascimento,dataadmissao) values(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, vendedor.getCod_vendedor());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getCpf());
            ps.setString(4, vendedor.getRg());
            ps.setString(5, vendedor.getTelefone());
            ps.setInt(6, id_endereco);
            ps.setDate(7, new Date(vendedor.getDatanascimento().getTime()));
            ps.setDate(8, new Date(vendedor.getDataadmissao().getTime()));
          
            ps.execute();
            JOptionPane.showMessageDialog(null, "Vendendor cadastrado com sucesso!");
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
        
        
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
        String cpf = null;
        String rg = null;
        String telefone = null;
        Date datanascimento = null;
        Date dataadmissao = null;
        String rua = null;
        String numero = null;
        String cep = null;
        String complemento = null;
        String bairro = null;
        String cidade = null;
        String estado = null;
        String comissao = null;
        
        try{
            nome = rs.getString(2);
            cpf = rs.getString(3);
            rg = rs.getString(4);
            telefone = rs.getString(5);
            datanascimento = rs.getDate(6);
            dataadmissao = rs.getDate(7);
            rua = rs.getString(8);
            numero = rs.getString(9);
            cep = rs.getString(10);
            complemento =  rs.getString(11);
            bairro = rs.getString(12);
            cidade = rs.getString(13);
            estado = rs.getString(14);
            comissao = rs.getString(15);
            
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        Endereco endereco = new Endereco(rua, numero, cep, complemento, bairro, cidade, estado);
       
        return new Vendedor(cod_vendedor, nome, cpf, rg, endereco, telefone, datanascimento, dataadmissao);

   
    }
    
    public void updateVendedorByCod_vendedor(Vendedor vendedor){
        
        PreparedStatement ps = null;
        String sql = " update vendedor set nome=?, comissao=? where cod_vendedor=?";
        
       try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, vendedor.getCod_vendedor());
           ps.setString(2, vendedor.getNome());
        
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
    }
}
        
        
    


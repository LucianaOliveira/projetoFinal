
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;
import model.Endereco;
import model.Funcionarios;

/**
 *
 * @author Luciana_2
 */
public class FuncionariosDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    EnderecoDao enderecoDao = new EnderecoDao();
    CargoDao cargoDao = new CargoDao();
    
    public void addFuncionarios(Funcionarios funcionarios){
        PreparedStatement ps = null;
        
        String sql = "insert into funcionarios (nome,cpf,rg,cargo,endereco,telefone,status,salario)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionarios.getNome());
            ps.setString(2, funcionarios.getCpf());
            ps.setString(3, funcionarios.getRg());
            ps.setString(4, cargoDao.nomecargo());
            ps.setInt(5,  enderecoDao.pegarID());
            ps.setString(6, funcionarios.getTelefone());
            ps.setString(7, funcionarios.getStatus());
            ps.setDouble(8, funcionarios.getSalario());
            ps.execute();
                    
        }catch(SQLException ex){
            ex.printStackTrace();
        
    }
    }
    
    public ArrayList<Funcionarios> getFuncionario(){
        
        ArrayList<Funcionarios> funcionario = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = " select * from funcionarios";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                funcionario.add(getFuncionarioFromSql(rs));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
            
        }return funcionario;
    }

    private Funcionarios getFuncionarioFromSql(ResultSet rs, int pegarID, String nomecargo) {
        
        String nome = null;
        String cpf = null;
        String rg = null;
        Cargo cargo = null;
        Endereco endereco = null;
        String telefone = null;
        String status = null;
        Double salario = null;
        
        try{
            nome = rs.getString(2);
            cpf = rs.getString(3);
            rg = rs.getString(4);
            nomecargo = rs.getString(5);
            pegarID = rs.getInt(6);
            telefone = rs.getString(7);
            status = rs.getString(8);
            salario = rs.getDouble(9);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return new Funcionarios(nome, cpf, rg, cargo, endereco, telefone, status, salario);
        
    }
    
    public void updateFuncionariosByCpf(Funcionarios funcionarios){
        PreparedStatement ps = null;
        String sql = "update funcionarios set nome=?, rg=?,cargo=?, endereco=?,telefone=?, status=?,salario=? where cpf =?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionarios.getNome());
            ps.setString(2, funcionarios.getCpf());
            ps.setString(3, funcionarios.getRg());
            ps.setString(4, cargoDao.nomecargo());
            ps.setInt(5, enderecoDao.pegarID());
            ps.setString(6, funcionarios.getTelefone());
            ps.setString(7, funcionarios.getStatus());
            ps.setDouble(8, funcionarios.getSalario());
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    private Funcionarios getFuncionarioFromSql(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

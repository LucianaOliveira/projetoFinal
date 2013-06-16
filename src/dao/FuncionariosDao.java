
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cargo;
import model.Endereco;
import model.Funcionarios;

/**
 *
 * @author Luciana_2
 */
public class FuncionariosDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    private EnderecoDao enderecoDao = new EnderecoDao();
    private CargoDao cargoDao = new CargoDao();
    
    
    public void addFuncionarios(Funcionarios funcionarios){
        Integer id_endereco = enderecoDao.addEndereco(funcionarios.getEndereco());
        String nomecargo = cargoDao.addCargo(funcionarios.getCargo());
        PreparedStatement ps = null;
        
        String sql = "insert into funcionarios (nome,cpf,rg,cargo,id_endereco,telefone,status,comissao,datanascimento,dataadmissao, nome_cargo) values(?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionarios.getNome());
            ps.setString(2, funcionarios.getCpf());
            ps.setString(3, funcionarios.getRg());
            ps.setInt(4, id_endereco);
            ps.setString(5, nomecargo);
            ps.setString(6, funcionarios.getTelefone());
            ps.setString(7, funcionarios.getStatus());
            ps.setDate(8, new Date(funcionarios.getDatanascimento().getTime())); 
            ps.setDate(9, new Date(funcionarios.getDataadmissao().getTime()));
            ps.execute();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            
                    
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

    private Funcionarios getFuncionarioFromSql(ResultSet rs) {
        
        String nome = null;
        String cpf = null;
        String rg = null;
        String telefone = null;
        String status = null;
        Double salario = null;
        Date datanascimento = null;
        Date dataadmissao = null;
        String rua = null;
        String numero = null;
        String cep = null;
        String complemento = null;
        String bairro = null;
        String cidade = null;
        String estado = null;
        
        
        try{
            nome = rs.getString(2);
            cpf = rs.getString(3);
            rg = rs.getString(4);
            telefone = rs.getString(5);
            status = rs.getString(6);
            salario = rs.getDouble(7);
            datanascimento = rs.getDate(8);
            dataadmissao = rs.getDate(9);
            rua = rs.getString(10);
            numero = rs.getString(11);
            cep = rs.getString(12);
            complemento =  rs.getString(13);
            bairro = rs.getString(14);
            cidade = rs.getString(15);
            estado = rs.getString(16);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        Endereco endereco = new Endereco(rua, numero, cep, complemento, bairro, cidade, estado);
        return new Funcionarios(nome, cpf, rg, null, endereco, telefone, status, datanascimento, dataadmissao);
        
    }
    
    public void updateFuncionariosByCpf(Funcionarios funcionarios){
        PreparedStatement ps = null;
        String sql = "update funcionarios set nome=? where cpf =?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionarios.getNome());
            ps.setString(2, funcionarios.getCpf());
            ps.executeQuery();
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    

    
    
}

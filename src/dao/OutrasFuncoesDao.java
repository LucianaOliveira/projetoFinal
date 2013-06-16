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
import model.OutrasFuncoes;

/**
 *
 * @author Luciana_2
 */
public class OutrasFuncoesDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    public Integer addOutrasFuncoes(OutrasFuncoes outrasfuncoes){
        
        PreparedStatement ps = null;
        String sql = "insert into outrasfuncoes(cod_funcao,nome,salario) values(?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, outrasfuncoes.getCod_funcoes());
            ps.setString(2, outrasfuncoes.getNome());
            ps.setDouble(3, outrasfuncoes.getSalario());
            ps.execute();
            return getLastOutrasFuncoes();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
        
    }
    private Integer getLastOutrasFuncoes() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select cod_funcao from outrasfuncoes order by cod_funcao";
        try {
            ps = con.prepareStatement(sql);
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

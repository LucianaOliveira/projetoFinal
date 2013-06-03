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
import model.OutrasFuncoes;

/**
 *
 * @author Luciana_2
 */
public class OutrasFuncoesDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    public void addOutrasFuncoes(OutrasFuncoes outrasfuncoes){
        
        PreparedStatement ps = null;
        String sql ="insert into outrasfuncoes(cod,nome,salario) values(?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, outrasfuncoes.getCod());
            ps.setString(2, outrasfuncoes.getNome());
            ps.setDouble(3, outrasfuncoes.getSalario());
            ps.execute();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    public ArrayList<OutrasFuncoes> getOutraFuncao(){
        ArrayList<OutrasFuncoes> outrafuncao = new ArrayList<>();
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String sql = "select * from outrasfuncoes";
        
        try{
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            while(rs.next()){
                outrafuncao.add(getOutraFuncaoFromSql(rs));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }return outrafuncao;
        
        
    }
    
    private OutrasFuncoes getOutraFuncaoFromSql(ResultSet rs){
        Integer cod = null;
        String nome = null;
        Double salario = null;
        
        try{
            cod = rs.getInt(1);
            nome = rs.getString(2);
            salario = rs.getDouble(3);
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }return new OutrasFuncoes(cod, nome, salario);
    }
    
    public void updateOutrasFuncoesByCod(OutrasFuncoes outrasfuncoes){
        PreparedStatement ps = null;
        String sql = "update outrasfuncoes set nome=?, salario=? where cod=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, outrasfuncoes.getCod());
            ps.setString(2, outrasfuncoes.getNome());
            ps.setDouble(3, outrasfuncoes.getSalario());
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

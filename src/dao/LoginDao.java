/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

/**
 *
 * @author Luciana_2
 */
public class LoginDao {
    
    public static Boolean fazerLogin(Login login){
        PreparedStatement ps = null;
        ResultSet rs = null;
         String sql = "select * from login where usuario=? and senha=?";
        try {
            ps = ConectaBanco.getConexao().prepareStatement(sql);
            ps.setString(1, login.getUsuario());
            ps.setString(2, login.getSenha());
            rs = ps.executeQuery();
            
            if(rs.next())
             return true;
                 else{
             return false;  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
       
         
    }

    
    
    
}


package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luciana_2
 */
class ConectaBanco {
    
    private static Connection con = null;
    
    
    public static Connection getConexao(){
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            return null;        
        
    }
        String caminho = "jdbc:postgresql://localhost:5432/projetoPOO";
        
        try{
            con = DriverManager.getConnection(caminho, "postgres", "post");
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }return con;
        
    }
    
    public static void main(String[] args){
        
        getConexao();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comissao;

/**
 *
 * @author Luciana_2
 */
public class ComissaoDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    private VendaDao vendaDao = new VendaDao();
    
    
    public String addComissao(Comissao comissao) throws SQLException, ClassNotFoundException{
        Integer numero_venda = vendaDao.addVenda(comissao.getVenda());
        
        PreparedStatement ps = null;
        
        String sql = "insert into comissao(comissao,numero_venda) values(?,?) ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, comissao.getComissao());
            ps.setInt(2, numero_venda);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}

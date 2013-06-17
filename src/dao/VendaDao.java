
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Venda;
import model.Vendedor;

/**
 *
 * @author Luciana_2
 */
public class VendaDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    private VendedorDao vendedorDao = new VendedorDao();
    
    
    public Integer addVenda(Venda venda) throws SQLException, ClassNotFoundException{
        Integer cod_vendedor = vendedorDao.addVendedor(venda.getVendedor());
       
        
        
        PreparedStatement ps = null;
        
        String sql = "insert into Venda(numero_venda, datapedido, quantidade,valor, cod_vendedor ) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, venda.getNumero_venda());
            ps.setDate(2, new Date(venda.getDatapedido().getTime()));
            ps.setInt(3, venda.getQuantidade());
            ps.setDouble(4, venda.getValor());
            ps.setInt(5, cod_vendedor);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
            return getLastVenda(); 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    
    }

    private Integer getLastVenda() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select max(numero_venda) from venda";
        
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

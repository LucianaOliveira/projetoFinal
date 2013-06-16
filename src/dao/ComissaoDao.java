/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import model.Comissao;

/**
 *
 * @author Luciana_2
 */
public class ComissaoDao {
    
    private Connection con = ConectaBanco.getConexao();
    
    private VendaDao vendaDao = new VendaDao();
    
    
    public void addComissao(Comissao comissao){
        Integer numero_venda = vendaDao.add
    }
    
}

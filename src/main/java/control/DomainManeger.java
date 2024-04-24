/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ConexaoHibernate;
import java.sql.SQLException;


public class DomainManeger {
    
    
   public DomainManeger() throws ClassNotFoundException, SQLException {
        // TESTE
        // ConexaoMySQL.getConexao();
        ConexaoHibernate.getSessionFactory().openSession();
   }

  
}

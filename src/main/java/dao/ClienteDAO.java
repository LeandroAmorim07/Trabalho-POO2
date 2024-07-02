
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 2022122760117
 */
public class ClienteDAO {
    
    private List<Cliente>  pesquisar(String pesq, int tipo){
        List <Cliente> lista = new ArrayList();
        Session sessao =null;
        
        try{
           sessao = ConexaoHibernate.getSessionFactory().openSession();
           sessao.beginTransaction();
           
           
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Cliente.class);
            Root tabela= consulta.from(Cliente.class);
            
            Predicate restricoes =null;
            switch(tipo){
                case 1: restricoes=builder.like(tabela.get("nomeCliente"), pesq+"%");
                    break;
                case 2:restricoes=builder.like(tabela.get("cpf"), pesq);
                    break;
                case 3:restricoes=builder.like(tabela.get("email"), pesq);
                    break;
                case 4:restricoes=builder.like(tabela.get("telefoneCliente"), pesq);
                    break;
                
            }
            consulta.where(restricoes);
            
            consulta.orderBy(builder.asc(tabela.get("nomeCliente")));
            lista = sessao.createQuery(consulta).getResultList();
            sessao.getTransaction().commit();
            sessao.close();
        }
        catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }
    
    
    
     public List<Cliente> pesquisarPorNome (String pesq) throws SQLException, ClassNotFoundException {
        return pesquisar(pesq,1);
        
    }
     
      public List<Cliente> pesquisarPorCPF (String pesq) throws SQLException, ClassNotFoundException {
        return pesquisar(pesq,2);        
    }
      
       public List<Cliente> pesquisarPorEmail (String pesq) throws SQLException, ClassNotFoundException {
        return pesquisar(pesq,3);        
    }
       
     public List<Cliente> pesquisarPorTelefone (String pesq) throws SQLException, ClassNotFoundException {
        return pesquisar(pesq,4);        
    }
}

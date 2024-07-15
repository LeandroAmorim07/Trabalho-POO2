/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author leandro
 */
public class ItemDAO {
      public List<Item> pesquisar(String pesq) {
        List<Item> lista = new ArrayList<>();
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
           
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Item> consulta = builder.createQuery(Item.class);
            Root<Item> tabela = consulta.from(Item.class);
            
          
            String Item= pesq;
            
         
            Predicate restricoes = builder.like(tabela.get("NomeItem"), Item+"%");
            
            consulta.where(restricoes);
            
           lista = sessao.createQuery(consulta).getResultList();
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null && sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException("Erro na consulta: " + ex.getMessage());
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        
        return lista;
    }
}

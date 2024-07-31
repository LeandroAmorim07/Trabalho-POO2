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

import model.Estadia;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author leandro
 */
public class EstadiaDAO {
    private List<Estadia> pesquisar(String pesq, int tipo) {
        List<Estadia> lista = new ArrayList<>();
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Estadia> consulta = builder.createQuery(Estadia.class);
            Root<Estadia> tabela = consulta.from(Estadia.class);

            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    Integer idCliente;
                    try {
                        idCliente = Integer.parseInt(pesq);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("O valor fornecido para o idCliente não é um número válido.");
                    }
                    restricoes = builder.equal(tabela.get("cliente").get("idCliente"), idCliente);
                    break;
                case 2:
                    
                    Integer numQuarto;
                    try {
                        numQuarto = Integer.parseInt(pesq);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("O valor fornecido para numQuarto não é um número válido.");
                    }
                    restricoes = builder.equal(tabela.get("quarto").get("numQuarto"), numQuarto);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de pesquisa inválido.");
            }
            consulta.where(restricoes);

            lista = sessao.createQuery(consulta).getResultList();
            sessao.getTransaction().commit();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(ex);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return lista;
    }
    
    
    
     public List<Estadia> pesquisarPorIdCliente (String pesq) throws SQLException, ClassNotFoundException {
        return pesquisar(pesq,1);
        
    }
     
      public List<Estadia> pesquisarPorNumQuarto (String pesq) throws SQLException, ClassNotFoundException {
        return pesquisar(pesq,2);        
    }
      
  
}

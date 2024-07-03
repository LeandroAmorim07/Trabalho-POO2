


package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Cliente;
import model.Quarto;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class QuartoDAO {
    
    
     public List<Quarto> pesquisar(String pesq) {
        List<Quarto> lista = new ArrayList<>();
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
           
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Quarto> consulta = builder.createQuery(Quarto.class);
            Root<Quarto> tabela = consulta.from(Quarto.class);
            
            // Convertendo o valor de pesq para int
            int numeroQuarto = Integer.parseInt(pesq);
            
            // Criando a restrição para pesquisar por número do quarto
            Predicate restricoes = builder.equal(tabela.get("numQuarto"), numeroQuarto);
            
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

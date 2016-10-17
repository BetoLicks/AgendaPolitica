package bean;

import entidade.Pessoas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Beto Licks
 */
@ManagedBean
public class PessoasBean {
    private Pessoas pessoas = new Pessoas();
    private List<Pessoas> lstpessoas = new ArrayList<>();
    
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    
    public String voltaPessoas(){
        return "pessoas";
    }
    
//--------------------------------------------------------------------------------------------------------
//-> LISTAGEM
//--------------------------------------------------------------------------------------------------------    
    private void listaPessoas(){
        try {
            lstpessoas = sessao.createCriteria(Pessoas.class).list();
        } catch (Exception e) {
            System.out.println("* * * ERRO AO MONTAR PESQUISA: "+e.getMessage());
        }
    }
    
//--------------------------------------------------------------------------------------------------------
//-> GRAVA    
//--------------------------------------------------------------------------------------------------------    
    public String salvaPessoa(){
        Transaction transacao = sessao.beginTransaction();
        try {            
            transacao.begin();
            sessao.save(pessoas);
            transacao.commit();
            return "pessoas";
        } catch (Exception e) {
            transacao.rollback();            
        } finally {
            sessao.close();            
        }
        
        return "pessoas";
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    public List<Pessoas> getLstpessoas() {
        return lstpessoas;
    }

    public void setLstpessoas(List<Pessoas> lstpessoas) {
        this.lstpessoas = lstpessoas;
    }
    
    
    
    
    

    
    
}

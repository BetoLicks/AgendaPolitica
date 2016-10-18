package bean;

import entidade.Pessoas;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Beto Licks
 */
@ManagedBean
@SessionScoped
public class PessoasBean {
    private Pessoas pessoas = new Pessoas();
    private List<Pessoas> lstpessoas = new ArrayList<>();
    
    public String voltaPessoas(){
        return "pessoas";
    }
    
    public PessoasBean(){
       listaPessoas(); 
    }
    
//--------------------------------------------------------------------------------------------------------
//-> LISTAGEM
//--------------------------------------------------------------------------------------------------------    
    private void listaPessoas(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
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
        Session sessao = HibernateUtil.getSessionFactory().openSession();        
        
        try {           
            Transaction transacao = sessao.getTransaction();
            System.out.println("* * *  NOME: "+pessoas.getNome());
            transacao.begin();
            sessao.save(pessoas);
            transacao.commit();
            return "pessoas";
        } catch (Exception e) {
            System.out.println("* * *  ERRO AO GRAVAR: "+e.getMessage());
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

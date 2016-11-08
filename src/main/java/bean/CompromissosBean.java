package bean;

import entidade.Compromissos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Funcoes;
import util.HibernateUtil;

/********************************************************************************************************************
 * @author Beto Licks
 * Outubro / 2016
 ********************************************************************************************************************/

@ManagedBean
@SessionScoped
public class CompromissosBean {
    private String tipoGrava;
    private Compromissos compromissos = new Compromissos();
    private List<Compromissos> lstcompromissos = new ArrayList<>();
    private Calendar wdtentrada = Calendar.getInstance();
    
    public String preparaCampos(){
        tipoGrava = "incluir";
        limpaCampos();
        return "formcompromissos";        
    }
    
//--------------------------------------------------------------------------------------------------------
//-> INICIAL
//--------------------------------------------------------------------------------------------------------    
    public CompromissosBean(){
       limpaCampos();
       listaCompromissos();  
    }    
    
    public String dadosCompromisssos(Compromissos c){
        tipoGrava = "alterar";
        compromissos = c;
        return "formcompromissos";
    }
    
    private void listaCompromissos(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            lstcompromissos = sessao.createCriteria(Compromissos.class).list();
        } catch (Exception e) {
            System.out.println("* * * ERRO AO MONTAR PESQUISA: "+e.getMessage());
        }
        
        sessao.close();
    }
            
    private void limpaCampos(){
        compromissos.setDescricao(null);
        compromissos.setDtcompromisso(null);        
        compromissos.setHrcompromisso(null);
        compromissos.setTitulo(null);
        compromissos.setLocalizacao(null);
        compromissos.setStatus(null);
        compromissos.setDescricao(null);
    }
    
    public String voltaCompromisso(){
        return "compromissos";
    }
    
    public String salvaCompromisso(){
        Session sessao = HibernateUtil.getSessionFactory().openSession(); 
        
        try {
            Transaction transacao = sessao.getTransaction();
            transacao.begin();
            
            if (tipoGrava.equals("incluir")){
                sessao.save(compromissos);
                Funcoes.Mensagem("Regitro incluído com sucesso.");
            }
            
            if (tipoGrava.equals("alterar")){
                sessao.update(compromissos);
                Funcoes.Mensagem("Regitro alterado com sucesso.");
            }            
            
            transacao.commit();
            limpaCampos();
            listaCompromissos();
        } catch (Exception e) {
            
        } finally {
            sessao.close();
        }
     
        return "compromissos";
    }

    public Compromissos getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(Compromissos compromissos) {
        this.compromissos = compromissos;
    }

    public List<Compromissos> getLstcompromissos() {
        return lstcompromissos;
    }

    public void setLstcompromissos(List<Compromissos> lstcompromissos) {
        this.lstcompromissos = lstcompromissos;
    }
    }
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
    private String tipoGrava;

//--------------------------------------------------------------------------------------------------------
//-> ALTERA A MENSAGEM DE TOPO
//--------------------------------------------------------------------------------------------------------       
    public String alteraTitulo(String wmensa){
        return wmensa;
    }
            
//--------------------------------------------------------------------------------------------------------
//-> PREPARAÇÃO DOS CAMPOS PARA INCLUSÃO
//--------------------------------------------------------------------------------------------------------       
    public String preparaCampos(){
        limpaCampos();
        return "formPessoas";        
    }
    
//--------------------------------------------------------------------------------------------------------
//-> DADOS PARA ALTERAÇÃO
//--------------------------------------------------------------------------------------------------------    
    public String dadosPessoa(Pessoas p){
        tipoGrava = "alterar";
        pessoas = p;
        return "formPessoas";
    }
    
//--------------------------------------------------------------------------------------------------------
//-> BOTÃO VOLTAR
//--------------------------------------------------------------------------------------------------------    
    public String voltaPessoas(){
        return "pessoas";
    }

//--------------------------------------------------------------------------------------------------------
//-> LISTAGEM INICIAL
//--------------------------------------------------------------------------------------------------------    
    public PessoasBean(){
       tipoGrava = "incluir";
       limpaCampos();
       listaPessoas();        
    }

//--------------------------------------------------------------------------------------------------------
//-> LIMPA CAMPOS
//--------------------------------------------------------------------------------------------------------    
    private void limpaCampos(){
        pessoas.setId(null);
        pessoas.setNome(null);
        pessoas.setTelefones(null);
        pessoas.setEndereco(null);
        pessoas.setApelido(null);
        pessoas.setComplemento(null);
        pessoas.setEmail(null);
        pessoas.setBairro(null);
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
            transacao.begin();
            
            //-> VERIFICO O TIPO DE GRAVAÇÃO
            if (tipoGrava.equals("incluir")){
               sessao.save(pessoas);
            } else {
               sessao.update(pessoas); 
            }
            
            transacao.commit();
            
            limpaCampos();            
            listaPessoas();
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

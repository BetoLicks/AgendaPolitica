package bean;

import entidade.Compromissos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pmm-dev
 */

@ManagedBean
public class CompromissosBean {
    private String tipoGrava;
    private Compromissos compromissos = new Compromissos();
    private List<Compromissos> lstcompromissos = new ArrayList<>();
    
    public String preparaCampos(){
        tipoGrava = "inclusao";
        limpaCampos();
        return "formcompromissos";        
    }
    
    private void limpaCampos(){
        compromissos.setDescricao(null);
        compromissos.setDtcompromisso(null);
        compromissos.setDtentrada(null);
        compromissos.setEndereco(null);
        compromissos.setHrcompromisso(null);
        compromissos.setRealizado(null);
    }

    public Compromissos getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(Compromissos compromissos) {
        this.compromissos = compromissos;
    }
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

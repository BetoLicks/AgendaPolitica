package util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Beto Licks
 * Outubro / 2016
 */

@ManagedBean
public class Funcoes {
    
    public static void Mensagem(String wmensa){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(wmensa, ""));
    }        
        
        
    
}

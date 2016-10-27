package entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author pmm-dev
 */

@Entity
@Table(name="tab_compromissos")
public class Compromissos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Calendar dtentrada;
    
    @Temporal(TemporalType.DATE)
    private Calendar dtcompromisso;
    
    @Temporal(TemporalType.TIME)
    private Calendar hrcompromisso;
    
    private String endereco;
    private String descricao;
    private Boolean realizado;
    
    @OneToOne
    @JoinColumn(name = "pessoa")
    private Pessoas pessoa;
    
    
    
    
    
    
    
    
    
    
    
    
}

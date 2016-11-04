package entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
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
    
    private String titulo;
    private String status;
    private String local;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDtentrada() {
        return dtentrada;
    }

    public void setDtentrada(Calendar dtentrada) {
        this.dtentrada = dtentrada;
    }

    public Calendar getDtcompromisso() {
        return dtcompromisso;
    }

    public void setDtcompromisso(Calendar dtcompromisso) {
        this.dtcompromisso = dtcompromisso;
    }

    public Calendar getHrcompromisso() {
        return hrcompromisso;
    }

    public void setHrcompromisso(Calendar hrcompromisso) {
        this.hrcompromisso = hrcompromisso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compromissos other = (Compromissos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
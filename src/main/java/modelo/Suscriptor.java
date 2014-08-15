package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="suscriptor")
public class Suscriptor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="idsuscriptor")
    private int id;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    public Suscriptor() {
    }

    public Suscriptor(String email, Date fecha) {
        this.email = email;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}

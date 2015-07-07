package POJO;
// Generated 07-06-2015 07:05:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cambio generated by hbm2java
 */
public class Cambio  implements java.io.Serializable {


     private Integer idCambio;
     private float cambioDollar;
     private Date fecha;
     private Set pagoses = new HashSet(0);
     private Set pagoCreditos = new HashSet(0);

    public Cambio() {
    }

	
    public Cambio(float cambioDollar, Date fecha) {
        this.cambioDollar = cambioDollar;
        this.fecha = fecha;
    }
    public Cambio(float cambioDollar, Date fecha, Set pagoses, Set pagoCreditos) {
       this.cambioDollar = cambioDollar;
       this.fecha = fecha;
       this.pagoses = pagoses;
       this.pagoCreditos = pagoCreditos;
    }
   
    public Integer getIdCambio() {
        return this.idCambio;
    }
    
    public void setIdCambio(Integer idCambio) {
        this.idCambio = idCambio;
    }
    public float getCambioDollar() {
        return this.cambioDollar;
    }
    
    public void setCambioDollar(float cambioDollar) {
        this.cambioDollar = cambioDollar;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getPagoses() {
        return this.pagoses;
    }
    
    public void setPagoses(Set pagoses) {
        this.pagoses = pagoses;
    }
    public Set getPagoCreditos() {
        return this.pagoCreditos;
    }
    
    public void setPagoCreditos(Set pagoCreditos) {
        this.pagoCreditos = pagoCreditos;
    }




}


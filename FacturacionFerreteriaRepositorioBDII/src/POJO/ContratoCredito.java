package POJO;
// Generated 07-06-2015 07:05:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ContratoCredito generated by hbm2java
 */
public class ContratoCredito  implements java.io.Serializable {


     private Integer idContratoCredito;
     private Venta venta;
     private Date fechaVencimiento;
     private float tasaInteres;
     private Set pagoCreditos = new HashSet(0);

    public ContratoCredito() {
    }

	
    public ContratoCredito(Venta venta, Date fechaVencimiento, float tasaInteres) {
        this.venta = venta;
        this.fechaVencimiento = fechaVencimiento;
        this.tasaInteres = tasaInteres;
    }
    public ContratoCredito(Venta venta, Date fechaVencimiento, float tasaInteres, Set pagoCreditos) {
       this.venta = venta;
       this.fechaVencimiento = fechaVencimiento;
       this.tasaInteres = tasaInteres;
       this.pagoCreditos = pagoCreditos;
    }
   
    public Integer getIdContratoCredito() {
        return this.idContratoCredito;
    }
    
    public void setIdContratoCredito(Integer idContratoCredito) {
        this.idContratoCredito = idContratoCredito;
    }
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }
    
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public float getTasaInteres() {
        return this.tasaInteres;
    }
    
    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    public Set getPagoCreditos() {
        return this.pagoCreditos;
    }
    
    public void setPagoCreditos(Set pagoCreditos) {
        this.pagoCreditos = pagoCreditos;
    }




}



package POJO;
// Generated 07-06-2015 07:05:42 PM by Hibernate Tools 4.3.1



/**
 * VentaCredito generated by hbm2java
 */
public class VentaCredito  implements java.io.Serializable {


     private Integer idVentaCredito;
     private Venta venta;
     private float mora;

    public VentaCredito() {
    }

    public VentaCredito(Venta venta, float mora) {
       this.venta = venta;
       this.mora = mora;
    }
   
    public Integer getIdVentaCredito() {
        return this.idVentaCredito;
    }
    
    public void setIdVentaCredito(Integer idVentaCredito) {
        this.idVentaCredito = idVentaCredito;
    }
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public float getMora() {
        return this.mora;
    }
    
    public void setMora(float mora) {
        this.mora = mora;
    }




}



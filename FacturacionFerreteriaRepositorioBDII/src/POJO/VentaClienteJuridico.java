package POJO;
// Generated 07-06-2015 07:05:42 PM by Hibernate Tools 4.3.1



/**
 * VentaClienteJuridico generated by hbm2java
 */
public class VentaClienteJuridico  implements java.io.Serializable {


     private Integer idFacturaClienteJuridico;
     private RepresentanteClienteJuridico representanteClienteJuridico;
     private Venta venta;

    public VentaClienteJuridico() {
    }

    public VentaClienteJuridico(RepresentanteClienteJuridico representanteClienteJuridico, Venta venta) {
       this.representanteClienteJuridico = representanteClienteJuridico;
       this.venta = venta;
    }
   
    public Integer getIdFacturaClienteJuridico() {
        return this.idFacturaClienteJuridico;
    }
    
    public void setIdFacturaClienteJuridico(Integer idFacturaClienteJuridico) {
        this.idFacturaClienteJuridico = idFacturaClienteJuridico;
    }
    public RepresentanteClienteJuridico getRepresentanteClienteJuridico() {
        return this.representanteClienteJuridico;
    }
    
    public void setRepresentanteClienteJuridico(RepresentanteClienteJuridico representanteClienteJuridico) {
        this.representanteClienteJuridico = representanteClienteJuridico;
    }
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }




}



package POJO;
// Generated 07-06-2015 07:05:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Vendedores generated by hbm2java
 */
public class Vendedores  implements java.io.Serializable {


     private Integer idVendedor;
     private Proveedores proveedores;
     private String cedula;
     private String primerNombre;
     private String segundoNombre;
     private String primerApellido;
     private String segundoApellido;
     private boolean estado;
     private Set compras = new HashSet(0);

    public Vendedores() {
    }

	
    public Vendedores(Proveedores proveedores, String cedula, String primerNombre, String segundoNombre, String primerApellido, boolean estado) {
        this.proveedores = proveedores;
        this.cedula = cedula;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.estado = estado;
    }
    public Vendedores(Proveedores proveedores, String cedula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, boolean estado, Set compras) {
       this.proveedores = proveedores;
       this.cedula = cedula;
       this.primerNombre = primerNombre;
       this.segundoNombre = segundoNombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.estado = estado;
       this.compras = compras;
    }
   
    public Integer getIdVendedor() {
        return this.idVendedor;
    }
    
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }
    public Proveedores getProveedores() {
        return this.proveedores;
    }
    
    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getPrimerNombre() {
        return this.primerNombre;
    }
    
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    public String getSegundoNombre() {
        return this.segundoNombre;
    }
    
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Set getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set compras) {
        this.compras = compras;
    }




}


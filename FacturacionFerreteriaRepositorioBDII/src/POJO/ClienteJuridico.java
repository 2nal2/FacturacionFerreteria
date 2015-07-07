package POJO;
// Generated 07-06-2015 07:05:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ClienteJuridico generated by hbm2java
 */
public class ClienteJuridico  implements java.io.Serializable {


     private Integer idclienteJuridico;
     private String nombre;
     private String ruc;
     private String direccion;
     private String telefono;
     private String correoElectronico;
     private float descuentoPorcentual;
     private boolean estado;
     private Set representanteClienteJuridicos = new HashSet(0);

    public ClienteJuridico() {
    }

	
    public ClienteJuridico(String nombre, String ruc, String direccion, String telefono, float descuentoPorcentual, boolean estado) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descuentoPorcentual = descuentoPorcentual;
        this.estado = estado;
    }
    public ClienteJuridico(String nombre, String ruc, String direccion, String telefono, String correoElectronico, float descuentoPorcentual, boolean estado, Set representanteClienteJuridicos) {
       this.nombre = nombre;
       this.ruc = ruc;
       this.direccion = direccion;
       this.telefono = telefono;
       this.correoElectronico = correoElectronico;
       this.descuentoPorcentual = descuentoPorcentual;
       this.estado = estado;
       this.representanteClienteJuridicos = representanteClienteJuridicos;
    }
   
    public Integer getIdclienteJuridico() {
        return this.idclienteJuridico;
    }
    
    public void setIdclienteJuridico(Integer idclienteJuridico) {
        this.idclienteJuridico = idclienteJuridico;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public float getDescuentoPorcentual() {
        return this.descuentoPorcentual;
    }
    
    public void setDescuentoPorcentual(float descuentoPorcentual) {
        this.descuentoPorcentual = descuentoPorcentual;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Set getRepresentanteClienteJuridicos() {
        return this.representanteClienteJuridicos;
    }
    
    public void setRepresentanteClienteJuridicos(Set representanteClienteJuridicos) {
        this.representanteClienteJuridicos = representanteClienteJuridicos;
    }




}


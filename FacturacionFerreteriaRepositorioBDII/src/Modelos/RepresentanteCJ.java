/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

/**
 *
 * @author martin
 */
public class RepresentanteCJ {
    
    private int IdRepresentante;
    public String NombreEmpresa;
    public String RUC;
    public String PrimerNombre;
    public String SegundoNombre;
    public String PrimerApellido;
    public String SegundoApellido;
    public String Cedula;
    public String Direccion;
    public String CorreoElectronico;
    public String Telefono;
    public boolean Estado;
    
    public RepresentanteCJ(){}

    public RepresentanteCJ(int IdRepresentante, String NombreEmpresa, String RUC, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String Cedula, String Direccion, String CorreoElectronico, String Telefono, boolean Estado) {
        this.IdRepresentante = IdRepresentante;
        this.NombreEmpresa = NombreEmpresa;
        this.RUC = RUC;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.CorreoElectronico = CorreoElectronico;
        this.Telefono = Telefono;
        this.Estado = Estado;
    }

    public int getIdRepresentante() {
        return IdRepresentante;
    }

    public void setIdRepresentante(int IdRepresentante) {
        this.IdRepresentante = IdRepresentante;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
    
}

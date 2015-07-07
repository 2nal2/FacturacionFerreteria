/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author ingdonaldo
 */
public class Factura {
    private int NoFactura;
    private String Fecha;
    private String Cajero;
    private String TipoFactura;
    private String Cliente;
    private double Subtotal;
    private double Descuento;
    private double IVA;
    private float Mora;
    private double Total;
    private String Estado;
    private boolean Anulado;

    public Factura(int NoFactura, String Fecha, String Cajero, String TipoFactura, String Cliente, double Subtotal, double Descuento, double IVA, float Mora, double Total, String Estado, boolean Anulado) {
        this.NoFactura = NoFactura;
        this.Fecha = Fecha;
        this.Cajero = Cajero;
        this.TipoFactura = TipoFactura;
        this.Cliente = Cliente;
        this.Subtotal = Subtotal;
        this.Descuento = Descuento;
        this.IVA = IVA;
        this.Mora = Mora;
        this.Total = Total;
        this.Estado = Estado;
        this.Anulado = Anulado;
    }
                      
    public Factura() {
    }

    public int getNoFactura() {
        return NoFactura;
    }

    public void setNoFactura(int NoFactura) {
        this.NoFactura = NoFactura;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getCajero() {
        return Cajero;
    }

    public void setCajero(String Cajero) {
        this.Cajero = Cajero;
    }

    public String getTipoFactura() {
        return TipoFactura;
    }

    public void setTipoFactura(String TipoFactura) {
        this.TipoFactura = TipoFactura;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public float getMora() {
        return Mora;
    }

    public void setMora(float Mora) {
        this.Mora = Mora;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public boolean isAnulado() {
        return Anulado;
    }

    public void setAnulado(boolean Anulado) {
        this.Anulado = Anulado;
    }
    
    
    
}

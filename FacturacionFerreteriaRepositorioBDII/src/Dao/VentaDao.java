package Dao;

import Hibernate.HibernateUtil;
import Modelos.Factura;
import POJO.Venta;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ing. Donaldo
 */
public class VentaDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public Venta getVenta(int id) {
        try {
            AbrirSession();
            return (Venta) session.get(Venta.class, id);
        } catch (Exception e) {
            System.out.println("" + e.getCause());
            System.out.println("" + e.getMessage());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public List<Factura> getFacturas() {
        //consulta de clientes juridicos con venta al credito
        String Consulta = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, empresa.nombre,\n"
                + "sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "sum(df.iva),vc.mora, \n"
                + "sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva) + vc.mora,\n"
                + "v.estado,\n"
                + "v.anulado)\n"
                + "from Venta v\n"
                + "inner join v.empleados e\n"
                + "inner join v.ventaCreditos vc\n"
                + "inner join v.detalleFacturas df\n"
                + "inner join v.ventaClienteJuridicos cj\n"
                + "inner join cj.representanteClienteJuridico representante\n"
                + "inner join representante.clienteJuridico empresa "
                + "group by v.noFactura";
        //consulta de clientes naturales con ventas al credito
        String Consulta2 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, concat(c.primerNombre,' ',c.primerApellido),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),vc.mora,\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva) + vc.mora,\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                inner join v.ventaClienteNaturals vcn\n"
                + "                inner join vcn.cliente c"
                + "                inner join v.ventaCreditos vc\n"
                + "                group by v.noFactura";
        //consulta de cliente juridico con venta al contado
        String Consulta3 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, empresa.nombre,\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),cast(0 as float),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva),\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                inner join v.ventaClienteJuridicos cj\n"
                + "inner join cj.representanteClienteJuridico representante\n"
                + "inner join representante.clienteJuridico empresa "
                + "                where v.tipoFactura = 'Contado'\n"
                + "                group by v.noFactura";
        //consulta de venta a clientes naturales al contado
        String Consulta4 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, concat(c.primerNombre,' ',c.primerApellido),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),cast( 0 as float),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva),\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                inner join v.ventaClienteNaturals vcn\n"
                + "                inner join vcn.cliente c "
                + "                where v.tipoFactura = 'Contado'"
                + "                group by v.noFactura";
        
        //consulta de facturas a contado (cualquera sin nombre)
        String Consulta5 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, '-',\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),cast(0 as float),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva),\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                where v.tipoFactura = 'Contado'\n"
                + "                group by v.noFactura";
        List<Factura> facturas;
        try {
            AbrirSession();
            
            Query q = session.createQuery(Consulta);
            facturas = (List<Factura>) q.list();
            
            Query q2 = session.createQuery(Consulta2);
            facturas.addAll((List<Factura>) q2.list());
            
            q2 = session.createQuery(Consulta3);
            facturas.addAll((List<Factura>) q2.list());
            
            q2 = session.createQuery(Consulta4);
            facturas.addAll((List<Factura>) q2.list());
            
            q2 = session.createQuery(Consulta5);
            
            for (Factura i : (List<Factura>) q2.list()) {
                if(!Repetido(facturas,i)){
                    facturas.add(i);
                }
                
            }
            return facturas;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("" + e.getCause());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }

    }
    
    public List<Factura> getFacturas(String FechaInicial,String FechaFinal) {
        //consulta de clientes juridicos con venta al credito
        String Consulta = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, empresa.nombre,\n"
                + "sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "sum(df.iva),vc.mora, \n"
                + "sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva) + vc.mora,\n"
                + "v.estado,\n"
                + "v.anulado)\n"
                + "from Venta v\n"
                + "inner join v.empleados e\n"
                + "inner join v.ventaCreditos vc\n"
                + "inner join v.detalleFacturas df\n"
                + "inner join v.ventaClienteJuridicos cj\n"
                + "inner join cj.representanteClienteJuridico representante\n"
                + "inner join representante.clienteJuridico empresa "
                + "where v.fechaVenta between :fecha1 and :fecha2 "
                + "group by v.noFactura";
        //consulta de clientes naturales con ventas al credito
        String Consulta2 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, concat(c.primerNombre,' ',c.primerApellido),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),vc.mora,\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva) + vc.mora,\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                inner join v.ventaClienteNaturals vcn\n"
                + "                inner join vcn.cliente c"
                + "                inner join v.ventaCreditos vc\n"
                + "                where v.fechaVenta between :fecha1 and :fecha2 "
                + "                group by v.noFactura";
        //consulta de cliente juridico con venta al contado
        String Consulta3 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, empresa.nombre,\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),cast(0 as float),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva),\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                inner join v.ventaClienteJuridicos cj\n"
                + "                inner join cj.representanteClienteJuridico representante\n"
                + "                inner join representante.clienteJuridico empresa "
                + "                where v.tipoFactura = 'Contado'\n"
                + "                and v.fechaVenta between :fecha1 and :fecha2 "
                + "                group by v.noFactura";
        //consulta de venta a clientes naturales al contado
        String Consulta4 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, concat(c.primerNombre,' ',c.primerApellido),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),cast( 0 as float),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva),\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                inner join v.ventaClienteNaturals vcn\n"
                + "                inner join vcn.cliente c "
                + "                where v.tipoFactura = 'Contado' "
                + "                and v.fechaVenta between :fecha1 and :fecha2 "
                + "                group by v.noFactura";
        
        //consulta de facturas a contado (cualquera sin nombre)
        String Consulta5 = "select new Modelos.Factura(v.noFactura, str(v.fechaVenta), concat(e.primerNombre,' ',e.primerApellido) , v.tipoFactura, '-',\n"
                + "                sum(df.cantidadProducto * df.precioUnitario ),sum(df.cantidadProducto * df.precioUnitario * df.descuento) ,\n"
                + "                sum(df.iva),cast(0 as float),\n"
                + "                sum(df.cantidadProducto * df.precioUnitario * (1-df.descuento) + df.iva),\n"
                + "                v.estado,\n"
                + "                v.anulado)\n"
                + "                from Venta v\n"
                + "                inner join v.empleados e\n"
                + "                inner join v.detalleFacturas df\n"
                + "                where v.tipoFactura = 'Contado'\n"
                + "                and v.fechaVenta between :fecha1 and :fecha2 "
                + "                group by v.noFactura";
        List<Factura> facturas;
        try {
            AbrirSession();
            
            Query q = session.createQuery(Consulta);
            q.setString("fecha1", FechaInicial);
            q.setString("fecha2", FechaFinal);
            facturas = (List<Factura>) q.list();
            
            Query q2 = session.createQuery(Consulta2);
            q2.setString("fecha1", FechaInicial);
            q2.setString("fecha2", FechaFinal);
            facturas.addAll((List<Factura>) q2.list());
            
            q2 = session.createQuery(Consulta3);
            q2.setString("fecha1", FechaInicial);
            q2.setString("fecha2", FechaFinal);
            facturas.addAll((List<Factura>) q2.list());
            
            q2 = session.createQuery(Consulta4);
            q2.setString("fecha1", FechaInicial);
            q2.setString("fecha2", FechaFinal);
            facturas.addAll((List<Factura>) q2.list());
            
            q2 = session.createQuery(Consulta5);
            q2.setString("fecha1", FechaInicial);
            q2.setString("fecha2", FechaFinal);
            
            for (Factura i : (List<Factura>) q2.list()) {
                if(!Repetido(facturas,i)){
                    facturas.add(i);
                }
                
            }
            return facturas;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("" + e.getCause());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }

    }
    
   
    public boolean Repetido(List<Factura> l,Factura f){
        for(Factura fa: l){
            if(fa.getNoFactura() == f.getNoFactura()){
                return true;
            }
        }
        
        return false;
    }

    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}

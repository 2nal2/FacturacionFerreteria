package Dao;

import Hibernate.HibernateUtil;
import POJO.Categorias;
import POJO.Cliente;
import POJO.CodigoBarra;
import POJO.Empleados;
import POJO.RepresentanteClienteJuridico;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ing. Donaldo
 */
public class Dao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public long Guardar(Object objeto) {
        int id;
        try {
            AbrirSession();
            id = (int) session.save(objeto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            System.out.println("Causa : " + e.getCause());
            Excepcion((HibernateException) e);
            return -1;
        } finally {
            session.close();
        }
        return id;
    }

    public String Guardar(CodigoBarra objeto) {
        String id;
        try {
            AbrirSession();
            id = (String) session.save(objeto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            System.out.println("Causa : " + e.getCause());
            Excepcion((HibernateException) e);
            return "";
        } finally {
            session.close();
        }
        return id;
    }

    public boolean Actualizar(Object objeto) {
        try {
            AbrirSession();
            session.update(objeto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            System.out.println("Causa : " + e.getCause());
            Excepcion((HibernateException) e);

            return false;
        } finally {
            session.close();
        }
    }

//    public void Prueba() {
//        AbrirSession();
//
//        Query query = session.createQuery("select new map(p.idproducto as ID) from Producto as p\n"
//                + "    inner join p.codigoBarras as mate\n"
//                + "    ");
//
//        List<Map> listaResultados = query.list();
//
//        for (int i = 0; i < listaResultados.size(); i++) {
//            Map mapa = listaResultados.get(i);
//
//            System.out.println("Datos del mapa " + i);
//
//            Set llaves = mapa.keySet();
//
//            for (Iterator<String> it = llaves.iterator(); it.hasNext();) {
//                String llaveActual = it.next();
//
//                System.out.println("\tLlave: " + llaveActual + ", valor: " + mapa.get(llaveActual));
//            }
//        }
//        session.close();
//    }
    public Empleados getByIdEmpleado(int id){
        try {
            AbrirSession();
            Empleados c = (Empleados) session.get(Empleados.class, id);
            return c;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }
    
    public Cliente getByIdClienteNatural(int id){
        try {
            AbrirSession();
            Cliente c = (Cliente) session.get(Cliente.class, id);
            return c;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }
    
    public RepresentanteClienteJuridico getByIdClienteJuridico(int id){
        try {
            AbrirSession();
            RepresentanteClienteJuridico c = (RepresentanteClienteJuridico) session.get(RepresentanteClienteJuridico.class, id);
            return c;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}

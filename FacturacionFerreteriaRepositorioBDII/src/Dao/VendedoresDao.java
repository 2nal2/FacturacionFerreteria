package Dao;

import Hibernate.HibernateUtil;
import Modelos.VendedoresP;
import POJO.Vendedores;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class VendedoresDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<Vendedores> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Vendedores");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Vendedores>) lista;
    }

    public Vendedores getById(int id) {
        try {
            AbrirSession();
            Vendedores ve = (Vendedores) session.get(Vendedores.class, id);
            return ve;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public List<VendedoresP> getProveedores() {
        List<VendedoresP> vende = null;

        try {
            AbrirSession();
            Query q = session.createQuery(
                    "select new Modelos.VendedoresP(v.idVendedor, p.nombre, p.ruc, v.cedula, v.primerNombre, "
                    + "v.segundoNombre, v.primerApellido, v.segundoApellido, v.estado) "
                    + "from Vendedores as v "
                    + "inner join v.proveedores p ");
            vende = q.list();
        } catch (Exception e) {
            session.close();
        }

        return (List<VendedoresP>) vende;
    }

    public String getNombreVendedores(int id) {

        try {
            AbrirSession();
            Query q = session.createQuery(
                    "select p.nombre, p.ruc from Vendedores v\n"
                    + "inner join v.proveedores p\n"
                    + "where v.idVendedor = :id");
            q.setInteger("id", id);
            return (String) q.list().get(0);
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    
    
    public List<Vendedores> getAllPorProveedor(int idproveedor){
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Vendedores v where idproveedor = :id");
            q.setInteger("id", idproveedor);
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Vendedores>) lista;
    }
    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

}

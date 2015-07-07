package Dao;

import Hibernate.HibernateUtil;
import POJO.CodigoBarra;
import POJO.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ing. Donaldo
 */
public class CodigoBarraDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public CodigoBarra getById(int id) {
        try {
            AbrirSession();
            Query q = session.createQuery("from CodigoBarra where idProducto =:parametro");
            q.setInteger("parametro", id);
            if (q.list().size() > 0) {
                return (CodigoBarra) q.list().get(0);
            } else {
                
                return new CodigoBarra();
            }
        } catch (Exception e) {
            System.out.println("" + e.getCause());
            System.out.println("" + e.getMessage());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }
    
    public Producto getProducto(String codigoBarra) {
        try {
            AbrirSession();
            Query q = session.createQuery("select p.idproducto from CodigoBarra as c inner join c.producto as p where c.idCodigoBarra =:parametro");
            q.setString("parametro", codigoBarra);
            int id;
            if (q.list().size() > 0) {
                id = (int)q.list().get(0);
                return (Producto)session.get(Producto.class, id);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("" + e.getCause());
            System.out.println("" + e.getMessage());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }
    
    public boolean Actualizar(CodigoBarra c, String codigo){
    try {
            AbrirSession();
            Query q = session.createSQLQuery("UPDATE `FacturacionFerreteria`.`CodigoBarra` SET `IdCodigoBarra`=:idNuevo WHERE `IdCodigoBarra`=:id ;");
            q.setString("idNuevo", c.getIdCodigoBarra());
            q.setString("id", codigo);
            q.executeUpdate();
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

    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}

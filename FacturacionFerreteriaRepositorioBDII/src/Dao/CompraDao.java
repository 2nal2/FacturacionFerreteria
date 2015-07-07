package Dao;

import Hibernate.HibernateUtil;
import POJO.Compra;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ing. Donaldo
 */
public class CompraDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public Compra getById(int id) {
        try {
            AbrirSession();
            Compra c = (Compra)session.get(Compra.class, id);
            return c;
        } catch (Exception e) {
            System.out.println("" + e.getCause());
            System.out.println("" + e.getMessage());
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

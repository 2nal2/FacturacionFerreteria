/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Hibernate.HibernateUtil;
import POJO.Cambio;
import POJO.CodigoBarra;
import POJO.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ingdonaldo
 */
public class CambioDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public Cambio getById(int id) {
        try {
            AbrirSession();
            return (Cambio) session.get(Cambio.class, id);
        } catch (Exception e) {
            System.out.println("" + e.getCause());
            System.out.println("" + e.getMessage());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public Cambio getLastCambio() {
        try {
            AbrirSession();
            Query q = session.createQuery("from Cambio order by idCambio").setMaxResults(1);
            return (Cambio) q.list().get(0);
        } catch (Exception e) {
            System.out.println("" + e.getCause());
            System.out.println("" + e.getMessage());
            return null;       
        } finally {
            session.close();
        }

    }
    
    public List<Cambio> getAll(){
            try {
            AbrirSession();
            Query q = session.createQuery("from Cambio order by idCambio");
            return (List<Cambio>) q.list();
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

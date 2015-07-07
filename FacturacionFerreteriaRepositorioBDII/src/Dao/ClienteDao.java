/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Hibernate.HibernateUtil;
import POJO.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class ClienteDao {
    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
      public List<Cliente> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Cliente");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Cliente>) lista;
    }
      
        public Cliente getById(int id) {
        try {
            AbrirSession();
            Cliente cl = (Cliente) session.get(Cliente.class, id);
            return cl;
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

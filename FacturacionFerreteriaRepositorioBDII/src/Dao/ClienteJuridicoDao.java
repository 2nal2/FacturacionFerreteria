/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Hibernate.HibernateUtil;
import POJO.ClienteJuridico;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class ClienteJuridicoDao {
    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
      public List<ClienteJuridico> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from ClienteJuridico");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<ClienteJuridico>) lista;
    }
      
        public ClienteJuridico getById(int id) {
        try {
            AbrirSession();
            ClienteJuridico cj = (ClienteJuridico) session.get(ClienteJuridico.class, id);
            return cj;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Hibernate.HibernateUtil;
import POJO.Empleados;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class EmpleadoDao {
 Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<Empleados> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Empleados");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Empleados>) lista;
    }

    public Empleados getById(int id) {
        try {
            AbrirSession();
            Empleados pr = (Empleados) session.get(Empleados.class, id);
            return pr;
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

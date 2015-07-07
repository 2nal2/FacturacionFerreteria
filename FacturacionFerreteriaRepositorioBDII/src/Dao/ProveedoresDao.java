/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Hibernate.HibernateUtil;
import POJO.Proveedores;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class ProveedoresDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<Proveedores> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Proveedores");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Proveedores>) lista;
    }

    public Proveedores getById(int id) {
        try {
            AbrirSession();
            Proveedores pr = (Proveedores) session.get(Proveedores.class, id);
            return pr;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }
    
//    public Proveedores getByName(String nombre) {
//        try {
//            AbrirSession();
//            Proveedores ve = (Proveedores) session.get(Proveedores.class, nombre);
//        }catch (Exception e) {
//            Excepcion((HibernateException) e);
//            return null;
//        } finally {
//            session.close();
//        }
//        return getByName(nombre);
//    }

    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}

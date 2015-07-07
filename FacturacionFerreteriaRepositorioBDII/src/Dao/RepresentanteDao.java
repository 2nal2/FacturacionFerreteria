/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Hibernate.HibernateUtil;
import Modelos.RepresentanteCJ;
import POJO.RepresentanteClienteJuridico;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class RepresentanteDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<RepresentanteClienteJuridico> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from RepresentanteClienteJuridico");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<RepresentanteClienteJuridico>) lista;
    }

    public RepresentanteClienteJuridico getById(int id) {
        try {
            AbrirSession();
            RepresentanteClienteJuridico rcj = (RepresentanteClienteJuridico) session.get(RepresentanteClienteJuridico.class, id);
            return rcj;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public List<RepresentanteCJ> getRepresentanteCJ() {

        List<RepresentanteCJ> repre = null;
        try {
            AbrirSession();
            Query q = session.createQuery(
                    "select new Modelos.RepresentanteCJ(r.idrepresentante, cj.nombre, cj.ruc, "
                    + "r.primerNombre, r.segundoNombre, r.primerApellido, r.segundoApellido, "
                    + "r.cedula, r.direccion, r.correoElectronico, r.telefono, r.estado ) "
                    + "from ClienteJuridico as cj "
                    + "inner join cj.representanteClienteJuridicos as r");
            repre = q.list();
        } catch (Exception e) {
            session.close();
        }
        return (List<RepresentanteCJ>) repre;
    }

    public String getNombreClinteJuridico(int id) {

        try {
            AbrirSession();
            Query q = session.createQuery(
                    "select cj.nombre from RepresentanteClienteJuridico rcj\n"
                    + "inner join rcj.clienteJuridico cj\n"
                    + "where rcj.idrepresentante= :id");
            q.setInteger("id", id);
            return (String) q.list().get(0);
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}

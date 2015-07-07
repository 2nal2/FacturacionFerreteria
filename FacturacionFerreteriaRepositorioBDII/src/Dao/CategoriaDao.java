package Dao;

import Hibernate.HibernateUtil;
import POJO.Categorias;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ing. Donaldo
 */
public class CategoriaDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<Categorias> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Categorias");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Categorias>) lista;
    }

    public List<Categorias> getAllActive() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Categorias where estado = true");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Categorias>) lista;
    }

    public Categorias getById(int id) {
        try {
            AbrirSession();
            Categorias c = (Categorias) session.get(Categorias.class, id);
            return c;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public Categorias getByName(String Name) {
        try {
            AbrirSession();
            Query q = session.createQuery("from Categorias where nombre =:name");
            q.setParameter("name", Name);
            return (Categorias) q.list().get(0);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("" + e.getCause());
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }
    
    public Categorias getByProducto(int IdProducto) {
        try {
            AbrirSession();
            Query q = session.createQuery("select c.nombre from Categorias c inner join c.productos as p"
                    + " where p.idproducto =:parametro");
            q.setString("parametro", String.valueOf(IdProducto));
            String nombre = (String)q.list().get(0);
            q = session.createQuery("from Categorias where nombre =:parametro");
            q.setString("parametro", nombre);
            return (Categorias)q.list().get(0);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("" + e.getCause());
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
